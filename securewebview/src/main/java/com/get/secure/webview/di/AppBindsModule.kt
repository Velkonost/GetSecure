package com.get.secure.webview.di

import com.get.secure.webview.adblock.allowlist.AllowListModel
import com.get.secure.webview.adblock.allowlist.SessionAllowListModel
import com.get.secure.webview.adblock.source.AssetsHostsDataSource
import com.get.secure.webview.adblock.source.HostsDataSource
import com.get.secure.webview.adblock.source.HostsDataSourceProvider
import com.get.secure.webview.adblock.source.PreferencesHostsDataSourceProvider
import com.get.secure.webview.database.adblock.HostsDatabase
import com.get.secure.webview.database.adblock.HostsRepository
import com.get.secure.webview.database.allowlist.AdBlockAllowListDatabase
import com.get.secure.webview.database.allowlist.AdBlockAllowListRepository
import com.get.secure.webview.database.bookmark.BookmarkDatabase
import com.get.secure.webview.database.bookmark.BookmarkRepository
import com.get.secure.webview.database.downloads.DownloadsDatabase
import com.get.secure.webview.database.downloads.DownloadsRepository
import com.get.secure.webview.database.history.HistoryDatabase
import com.get.secure.webview.database.history.HistoryRepository
import com.get.secure.webview.database.javascript.JavaScriptDatabase
import com.get.secure.webview.database.javascript.JavaScriptRepository
import com.get.secure.webview.ssl.SessionSslWarningPreferences
import com.get.secure.webview.ssl.SslWarningPreferences
import dagger.Binds
import dagger.Module

/**
 * Dependency injection module used to bind implementations to interfaces.
 */
@Module
abstract class AppBindsModule {

    @Binds
    abstract fun provideBookmarkModel(bookmarkDatabase: BookmarkDatabase): BookmarkRepository

    @Binds
    abstract fun provideDownloadsModel(downloadsDatabase: DownloadsDatabase): DownloadsRepository

    @Binds
    abstract fun providesHistoryModel(historyDatabase: HistoryDatabase): HistoryRepository

    @Binds
    abstract fun providesJavaScriptModel(javaScriptDatabase: JavaScriptDatabase): JavaScriptRepository

    @Binds
    abstract fun providesAdBlockAllowListModel(adBlockAllowListDatabase: AdBlockAllowListDatabase): AdBlockAllowListRepository

    @Binds
    abstract fun providesAllowListModel(sessionAllowListModel: SessionAllowListModel): AllowListModel

    @Binds
    abstract fun providesSslWarningPreferences(sessionSslWarningPreferences: SessionSslWarningPreferences): SslWarningPreferences

    @Binds
    abstract fun providesHostsDataSource(assetsHostsDataSource: AssetsHostsDataSource): HostsDataSource

    @Binds
    abstract fun providesHostsRepository(hostsDatabase: HostsDatabase): HostsRepository

    @Binds
    abstract fun providesHostsDataSourceProvider(preferencesHostsDataSourceProvider: PreferencesHostsDataSourceProvider): HostsDataSourceProvider
}
