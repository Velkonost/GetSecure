package com.get.secure

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import com.get.secure.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.get.secure.di.AppModule
import com.get.secure.util.Preferences
import com.get.secure.util.ResourcesProvider
import timber.log.Timber
import com.github.terrakok.cicerone.Cicerone
import com.google.firebase.analytics.FirebaseAnalytics

import java.util.*

class App : DaggerApplication() {

    private val cicerone = Cicerone.create()

    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    private var mActivityTransitionTimer: Timer? = null
    private var mActivityTransitionTimerTask: TimerTask? = null
    var wasInBackground = false
    private val MAX_ACTIVITY_TRANSITION_TIME_MS: Long = 1200000

    private val appComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
//        .retrofitModule(RetrofitModule(this))
        .build()

    override fun onCreate() {
        super.onCreate()

        instance = this
        preferences = Preferences(this)
        resourcesProvider = ResourcesProvider(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        createNotificationChannel()
    }

    fun getAppComponent() = appComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent

    private fun createNotificationChannel() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel =
                NotificationChannel(
                    getString(R.string.default_notification_channel_id),
                    getString(R.string.default_notification_channel_id),
                    importance
                )
            notificationManager.createNotificationChannel(notificationChannel)
            Timber.d("isNotificationChannelCreated")
        }
    }

    fun startActivityTransitionTimer() {
        mActivityTransitionTimer = Timer()
        mActivityTransitionTimerTask = object : TimerTask() {
            override fun run() {
                this@App.wasInBackground = true
            }
        }
        mActivityTransitionTimer!!.schedule(
            mActivityTransitionTimerTask,
            MAX_ACTIVITY_TRANSITION_TIME_MS
        )
    }

    fun stopActivityTransitionTimer() {
        mActivityTransitionTimerTask?.cancel()
        mActivityTransitionTimer?.cancel()
        wasInBackground = false
    }


    companion object {
        lateinit var instance: App
        lateinit var preferences: Preferences
        lateinit var firebaseAnalytics: FirebaseAnalytics

        @SuppressLint("StaticFieldLeak")
        lateinit var resourcesProvider: ResourcesProvider
    }
}

