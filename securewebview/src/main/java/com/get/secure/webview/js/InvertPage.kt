package com.get.secure.webview.js

import com.anthonycr.mezzanine.FileStream


@FileStream("app/src/main/js/InvertPage.js")
interface InvertPage {

    fun provideJs(): String

}