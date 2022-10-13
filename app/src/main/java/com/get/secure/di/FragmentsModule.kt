package com.get.secure.di

import com.get.secure.ui.splash.di.SplashModule
import dagger.Module

@Module(
    includes = [
        SplashModule::class,
    ]
)
class FragmentsModule