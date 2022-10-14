package com.get.secure.webview.database

sealed class SettingsKeys(
        open val key: String,
        open val value: String
)