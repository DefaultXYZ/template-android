package defaultxyz.template.android.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import defaultxyz.template.android.presentation.main.MainActivity

@Module
interface ActivityBinder {

    @ContributesAndroidInjector
    fun contributesMainActivity(): MainActivity
}