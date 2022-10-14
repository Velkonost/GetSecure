package com.get.secure.ui.browser

import com.get.secure.R
import com.get.secure.databinding.FragmentSplashBinding
import com.get.secure.ui.base.BaseFragment

class BrowserFragment : BaseFragment<BrowserViewModel, FragmentSplashBinding>(
    R.layout.fragment_browser,
    BrowserViewModel::class,
    Handler::class
) {

    inner class Handler

}