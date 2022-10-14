package com.get.secure.ui.browser.di

import com.get.secure.ui.browser.BrowserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface BrowserModule {
    @ContributesAndroidInjector
    fun inject(): BrowserFragment
}