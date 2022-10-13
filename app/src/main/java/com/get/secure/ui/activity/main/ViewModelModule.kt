package com.get.secure.ui.activity.main

import androidx.lifecycle.ViewModel
import com.get.secure.di.SpecificReposModule
import com.get.secure.di.scope.ViewModelKey
import com.get.secure.ui.CommonViewModelModule
import com.get.secure.ui.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [CommonViewModelModule::class, MainProvidersModule::class, SpecificReposModule::class])
interface ViewModelModule {
    @ContributesAndroidInjector
    fun inject(): MainActivity
}

@Module
interface MainProvidersModule {


    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun splashViewModel(m: SplashViewModel): ViewModel
}