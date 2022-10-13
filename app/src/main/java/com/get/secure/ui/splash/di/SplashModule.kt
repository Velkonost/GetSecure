package com.get.secure.ui.splash.di

import com.get.secure.ui.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface SplashModule {
    @ContributesAndroidInjector
    fun inject(): SplashFragment
}