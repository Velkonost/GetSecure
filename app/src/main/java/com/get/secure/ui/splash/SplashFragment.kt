package com.get.secure.ui.splash

import com.get.secure.R
import com.get.secure.databinding.FragmentSplashBinding
import com.get.secure.ui.base.BaseFragment

class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>(
    R.layout.fragment_splash,
    SplashViewModel::class,
    Handler::class
) {

    inner class Handler

}