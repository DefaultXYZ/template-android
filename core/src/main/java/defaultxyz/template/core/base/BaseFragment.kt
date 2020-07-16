package defaultxyz.template.core.base

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import dagger.android.support.AndroidSupportInjection
import defaultxyz.template.core.extensions.applyOnType
import defaultxyz.template.core.extensions.showToast

abstract class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
        applyOnType<HasLifecycleViewModel> {
            lifecycle.addObserver(viewModel)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        applyOnType<HasDebugErrorViewModel> {
            viewModel.error.observe {
                showToast(it)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        applyOnType<HasRecyclerList> {
            recyclerView.adapter = adapter
            adapter.owner = recyclerView
        }
    }

    override fun onPause() {
        applyOnType<HasRecyclerList> {
            adapter.onClear()
            recyclerView.adapter = null
            adapter.owner = null
        }
        super.onPause()
    }

    override fun onDestroyView() {
        applyOnType<HasRecyclerList> {
            adapter.removeOnItemClickListener()
        }
        super.onDestroyView()
    }

    override fun onDestroy() {
        applyOnType<HasLifecycleViewModel> {
            lifecycle.removeObserver(viewModel)
        }
        super.onDestroy()
    }

    protected fun <T : Any> LiveData<T>.observe(observer: (T) -> Unit) {
        observe(viewLifecycleOwner, Observer { observer(it) })
    }

    inline fun <reified T : Activity> startActivity(
        finishCurrent: Boolean = false,
        bundle: Bundle? = null
    ) {
        Intent(context, T::class.java).apply {
            if (bundle != null) {
                putExtras(bundle)
            }
            startActivity(this)
            if (finishCurrent) {
                activity?.finish()
            }
        }
    }
}