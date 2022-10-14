package com.get.secure.webview.html.bookmark

import com.anthonycr.mezzanine.FileStream

/**
 * The store for the bookmarks HTML.
 */
@FileStream("app/src/main/html/bookmark.html")
interface BookmarkPageReader {

    fun provideHtml(): String

}