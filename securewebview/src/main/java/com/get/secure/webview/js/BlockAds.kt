package com.get.secure.webview.js

import com.anthonycr.mezzanine.FileStream


@FileStream("app/src/main/js/ElementBlockTest.js")
interface BlockAds {

    fun provideJs(): String

}