package com.get.secure.push.di

import com.get.secure.push.FirebaseMessagingService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ServiceBuilderModule {
    @ContributesAndroidInjector
    fun inject(): FirebaseMessagingService

}