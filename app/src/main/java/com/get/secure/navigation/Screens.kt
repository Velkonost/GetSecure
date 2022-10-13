package com.get.secure.navigation

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.get.secure.ui.splash.SplashFragment

object Screens {

    fun splashScreen() = FragmentScreen {
        SplashFragment()
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