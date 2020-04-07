package defaultxyz.template.android.presentation.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import defaultxyz.template.android.R
import defaultxyz.template.core.base.BaseActivity
import defaultxyz.template.core.extensions.lazyViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by lazyViewModel { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
