package com.get.secure.webview.preference

import android.app.Application
import android.webkit.WebSettings
import com.get.secure.webview.constant.DESKTOP_USER_AGENT
import com.get.secure.webview.constant.MOBILE_USER_AGENT

/**
 * Return the user agent chosen by the user or the custom user agent entered by the user.
 */
fun UserPreferences.userAgent(application: Application): String =
    when (val choice = userAgentChoice) {
        1 -> WebSettings.getDefaultUserAgent(application)
        2 -> DESKTOP_USER_AGENT
        3 -> MOBILE_USER_AGENT
        4 -> userAgentString.takeIf(String::isNotEmpty) ?: " "
        else -> throw UnsupportedOperationException("Unknown userAgentChoice: $choice")
    }
