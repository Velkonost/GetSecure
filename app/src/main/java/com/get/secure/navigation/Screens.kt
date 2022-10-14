package com.get.secure.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.get.secure.ui.browser.BrowserFragment
import com.get.secure.ui.splash.SplashFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun splashScreen() = FragmentScreen {
        SplashFragment()
    }

    fun browserScreen() = FragmentScreen {
        BrowserFragment()
    }
}

class BaseFragmentScreen(
    private val fragment: Fragment,
    private val isClear: Boolean = false,
    private val key: String
) :
    FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment = fragment

    fun toFragment() = fragment

    override val clearContainer: Boolean = isClear
    override val screenKey: String = key
}