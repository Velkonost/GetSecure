package com.get.secure.di

import com.get.secure.ui.browser.BrowserFragment
import com.get.secure.ui.splash.di.SplashModule
import dagger.Module

@Module(
    includes = [
        SplashModule::class,
        BrowserFragment::class
    ]
)
class FragmentsModule