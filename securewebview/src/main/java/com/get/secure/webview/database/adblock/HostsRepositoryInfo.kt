package com.get.secure.webview.database.adblock

import android.content.SharedPreferences
import com.get.secure.webview.di.AdBlockPrefs
import com.get.secure.webview.preference.delegates.nullableStringPreference
import javax.inject.Inject

/**
 * Information about the contents of the hosts repository.
 */
class HostsRepositoryInfo @Inject constructor(@AdBlockPrefs preferences: SharedPreferences) {

    /**
     * The identity of the contents of the hosts repository as a [String] or `null`.
     */
    var identity: String? by preferences.nullableStringPreference(IDENTITY)

    companion object {
        private const val IDENTITY = "identity"
    }

}

