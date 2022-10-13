package com.get.secure.util

import android.content.Context
import android.content.SharedPreferences
import com.get.secure.App
import java.util.*

class Preferences(context: Context) {

    private val sharedPreferences: SharedPreferences

    init {
        if (context !is App) {
            throw IllegalArgumentException("Expected application context")
        }
        sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }


    var locale: String
        set(value) = sharedPreferences.edit().putString(LOCALE, value).apply()
        get() =
            if (Locale.getDefault().language == "en" || Locale.getDefault().language == "ru")
                Locale.getDefault().language
            else "en"

    var isFirstLaunch: Boolean
        set(value) = sharedPreferences.edit().putBoolean(IS_FIRST_LAUNCH, value)
            .apply()
        get() = sharedPreferences.getBoolean(IS_FIRST_LAUNCH, true)

    var isPushAvailable: Boolean
        set(value) = sharedPreferences.edit().putBoolean(IS_PUSH_AVAILABLE, value)
            .apply()
        get() = sharedPreferences.getBoolean(IS_PUSH_AVAILABLE, true)

    var userId: String
        set(value) = sharedPreferences.edit().putString(USER_ID, value)
            .apply()
        get() = sharedPreferences.getString(USER_ID, "")?: ""

    companion object {
        const val PREF_FILE_NAME = "cv_prefs_get_secure"

        const val USER_ID = "user_id"
        const val LOCALE = "locale"
        const val IS_FIRST_LAUNCH = "is_first_launch"

        const val IS_DARK_THEME = "is_dark_theme"

        const val IS_PUSH_AVAILABLE = "is_push_available"
        const val IS_ONBOARDING_COMPLETED = "is_onboarding_completed"
        const val IS_PREMIUM = "is_premium"

    }
}