package defaultxyz.template.core.base

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import dagger.android.AndroidInjection
import defaultxyz.template.core.extensions.applyOnType
import defaultxyz.template.core.extensions.showToast

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        applyOnType<HasDebugErrorViewModel> {
            viewModel.error.observe {
                showToast(it)
            }
        }
        applyOnType<HasLifecycleViewModel> {
            lifecycle.addObserver(viewModel)
        }
    }

    override fun onDestroy() {
        applyOnType<HasLifecycleViewModel> {
            lifecycle.removeObserver(viewModel)
        }
        super.onDestroy()
    }

    protected fun <T : Any> LiveData<T>.observe(observer: (T) -> Unit) {
        observe(this@BaseActivity, Observer { observer(it) })
    }

    protected fun addFragment(
        fragment: Fragment, container: ViewGroup? = null,
        tag: String? = null, addToBackStack: Boolean = false
    ) {
        val transaction = supportFragmentManager.beginTransaction()

        if (container != null) {

            if (container.id == View.NO_ID) {
                throw IllegalArgumentException("View must have id to add fragment")
            }

            transaction.add(container.id, fragment)
        } else {
            transaction.add(android.R.id.content, fragment, tag)
        }

        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }

        transaction.commit()
    }

    protected fun replaceFragment(
        fragment: Fragment, container: ViewGroup? = null,
        tag: String? = null, addToBackStack: Boolean = false
    ) {
        val transaction = supportFragmentManager.beginTransaction()

        if (container != null) {

            if (container.id == View.NO_ID) {
                throw IllegalArgumentException("View must have id to add fragment")
            }

            transaction.replace(container.id, fragment)
        } else {
            transaction.replace(android.R.id.content, fragment, tag)
        }

        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }

        transaction.commit()
    }

    protected fun removeFragment(fragmentClass: Class<out Fragment>) {
        supportFragmentManager.fragments
            .filterIsInstance(fragmentClass)
            .firstOrNull()
            ?.let { fragment ->
                supportFragmentManager.beginTransaction()
                    .remove(fragment)
                    .commit()
            }
    }
}