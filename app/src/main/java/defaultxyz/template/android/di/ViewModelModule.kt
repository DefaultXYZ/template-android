package defaultxyz.template.android.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import defaultxyz.template.android.di.annotation.ViewModelKey
import defaultxyz.template.android.presentation.main.MainViewModel
import defaultxyz.template.core.di.ViewModelFactory

@Module
interface ViewModelModule {

    @Binds
    fun bindsViewModelProvider(provider: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindsMainViewModel(viewModel: MainViewModel): ViewModel
}