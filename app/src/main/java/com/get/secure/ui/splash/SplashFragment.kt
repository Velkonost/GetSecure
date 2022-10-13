package com.get.secure.ui.splash

import android.content.res.Configuration
import android.os.Bundle
import com.get.secure.R
import com.get.secure.databinding.FragmentSplashBinding
import com.get.secure.navigation.Screens
import com.get.secure.ui.base.BaseFragment
import org.greenrobot.eventbus.EventBus

class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>(
    R.layout.fragment_splash,
    SplashViewModel::class,
    Handler::class
) {

    override fun onLayoutReady(savedInstanceState: Bundle?) {
        super.onLayoutReady(savedInstanceState)


    }

    private fun initStartPage() {

    }

    inner class Handler {

    }

}