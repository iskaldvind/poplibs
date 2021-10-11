package io.iskaldvind.poplibs.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.iskaldvind.poplibs.presentation.MainActivity

@Module
interface MainModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

}