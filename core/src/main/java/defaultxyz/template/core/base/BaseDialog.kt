package defaultxyz.template.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import dagger.android.support.AndroidSupportInjection

abstract class BaseDialog : DialogFragment() {

    abstract fun inflateLayout(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflateLayout(inflater, container)

    protected fun <T : Any> LiveData<T>.observe(observer: (T) -> Unit) {
        observe(viewLifecycleOwner, Observer { observer(it) })
    }
}