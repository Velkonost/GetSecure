package com.get.secure.webview.js

import com.anthonycr.mezzanine.FileStream


@FileStream("app/src/main/js/CookieBlock.js")
interface CookieBlock {

    fun provideJs(): String

}