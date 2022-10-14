package com.get.secure.webview.ssl

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat

/**
 * Creates the proper [Drawable] to represent the [SslState].
 */
fun Context.createSslDrawableForState(sslState: SslState): Drawable? = when (sslState) {
    is SslState.None -> {
        ResourcesCompat.getDrawable(resources, R.drawable.ic_unsecured, theme)
    }
   is SslState.Valid -> {
       ResourcesCompat.getDrawable(resources, R.drawable.ic_secured, theme)
    }
    is SslState.Invalid -> {
        ResourcesCompat.getDrawable(resources, R.drawable.ic_unsecured_severe, theme)
    }
}
