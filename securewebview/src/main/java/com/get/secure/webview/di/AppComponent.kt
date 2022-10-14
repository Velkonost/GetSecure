package com.get.secure.webview.di


import android.app.Application
import com.get.secure.webview.device.BuildInfo
import com.get.secure.webview.dialog.LightningDialogBuilder
import com.get.secure.webview.view.SmartCookieView
import com.get.secure.webview.view.SmartCookieWebClient
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (AppBindsModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun buildInfo(buildInfo: BuildInfo): Builder

        fun build(): AppComponent
    }

    fun inject(activity: BrowserActivity)

    fun inject(activity: DownloadActivity)

    fun inject(activity: HistoryActivity)

    fun inject(fragment: ExportSettingsFragment)

    fun inject(builder: LightningDialogBuilder)

    fun inject(smartCookieView: SmartCookieView)

    fun inject(activity: ThemableBrowserActivity)

    fun inject(advancedSettingsFragment: AdvancedSettingsFragment)

    fun inject(app: BrowserApp)

    fun inject(activity: ReadingActivity)

    fun inject(webClient: SmartCookieWebClient)

    fun inject(activity: SettingsActivity)

    fun inject(activity: ThemableSettingsActivity)

    fun inject(listener: LightningDownloadListener)

    fun inject(fragment: PrivacySettingsFragment)

    fun inject(fragment: DebugSettingsFragment)

    fun inject(fragment: ExtensionsSettingsFragment)

    fun inject(suggestionsAdapter: SuggestionsAdapter)

    fun inject(chromeClient: SmartCookieChromeClient)

    fun inject(searchBoxModel: SearchBoxModel)

    fun inject(generalSettingsFragment: GeneralSettingsFragment)

    fun inject(displaySettingsFragment: DisplaySettingsFragment)

    fun inject(adBlockSettingsFragment: AdBlockSettingsFragment)

    fun inject(drawerSettingsFragment: DrawerSettingsFragment)

    fun inject(homepageSettingsFragment: HomepageSettingsFragment)

    fun inject(themeSettingsFragment: ThemeSettingsFragment)

    fun inject(drawerOffsetFragment: DrawerOffsetFragment)

    fun inject(parentalSettingsFragment: ParentalControlSettingsFragment)

    fun inject(bookmarksView: BookmarksDrawerView)

    fun provideBloomFilterAdBlocker(): BloomFilterAdBlocker

    fun provideNoOpAdBlocker(): NoOpAdBlocker

    fun inject(popUpClass: PopUpClass)

    fun inject(searchEngineFragment: SearchEngineFragment)

    fun inject(themeChoiceFragment: ThemeChoiceFragment)

    fun inject(navbarChoiceFragment: NavbarChoiceFragment)

    fun inject(permsFragmenst: PermsFragment)

    fun inject(onboarding: Onboarding)
}
