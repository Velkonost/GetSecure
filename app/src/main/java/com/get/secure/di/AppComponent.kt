package com.get.secure.di

import android.app.Application
import com.get.secure.App
import com.get.secure.di.scope.AppScope
import com.get.secure.push.di.ServiceBuilderModule
import com.get.secure.ui.activity.main.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@AppScope
@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
//        RetrofitModule::class,
        ServiceBuilderModule::class,
        AppModule::class,
        ReposModule::class,
        ViewModelFactoryModule::class,
        ViewModelModule::class,
        FragmentsModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    fun inject(app: Application)

}