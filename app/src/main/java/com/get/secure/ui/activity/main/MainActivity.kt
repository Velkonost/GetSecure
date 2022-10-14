package com.get.secure.ui.activity.main

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.app.WallpaperManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import com.get.secure.App
import com.get.secure.R
import com.get.secure.RequestCodes
import com.get.secure.databinding.ActivityMainBinding
import com.get.secure.navigation.Screens
import com.get.secure.navigation.SupportAppNavigator
import com.get.secure.ui.base.BaseActivity
import com.get.secure.ui.base.BaseFragment
import com.get.secure.util.checkPermissionForReadExternalStorage
import com.get.secure.vm.BaseViewModel


class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>(
    R.layout.activity_main,
    BaseViewModel::class,
    Handler::class
) {

    private lateinit var navigator: SupportAppNavigator

    private val navigationHolder by lazy {
        App.instance.navigatorHolder
    }

    private val router by lazy {
        App.instance.router
    }

    private var isActive = false

    override fun onLayoutReady(savedInstanceState: Bundle?) {
        super.onLayoutReady(savedInstanceState)

        if (savedInstanceState == null) {
            initStartPage()
        }

        navigator = SupportAppNavigator(this, R.id.subContainer)
        navigationHolder.setNavigator(navigator)

        registerReceiver(onDownloadComplete, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))

        setupWallpaper()
    }

    private fun setupWallpaper() {
        if (this.checkPermissionForReadExternalStorage()) {
            kotlin.runCatching {
                val wallpaperManager = WallpaperManager.getInstance(this)
                binding.container.background = wallpaperManager.drawable
            }.onFailure {

            }
        } else {

        }
    }

    private val onDownloadComplete: BroadcastReceiver = object : BroadcastReceiver() {
        @SuppressLint("Range")
        override fun onReceive(context: Context?, intent: Intent) {
            val extras = intent.extras
            val dm = getSystemService(DOWNLOAD_SERVICE) as DownloadManager

            val q = DownloadManager.Query()
            q.setFilterById(extras!!.getLong(DownloadManager.EXTRA_DOWNLOAD_ID))
            val c: Cursor = dm.query(q)

            if (c.moveToFirst()) {
                val status: Int = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS))
                if (status == DownloadManager.STATUS_SUCCESSFUL) {
                    title = c.getString(c.getColumnIndex(DownloadManager.COLUMN_TITLE))
                }
            }
        }
    }

    private fun initStartPage() {
        router.replaceScreen(Screens.splashScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()

        if (::navigator.isInitialized)
            navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigationHolder.removeNavigator()

        isActive = false
        (this.application as App).startActivityTransitionTimer()
        super.onPause()
    }

    override fun onViewModelReady(viewModel: BaseViewModel) {
    }

    override fun onResume() {
        super.onResume()

        isActive = true

        val myApp: App = this.application as App
        if (myApp.wasInBackground) {

            finish()
            overridePendingTransition(0, 0)
            startActivity(intent)
            overridePendingTransition(0, 0)
            //Do specific came-here-from-background code
        }
        myApp.stopActivityTransitionTimer()
    }

    override fun onStop() {
        super.onStop()
        isActive = false
    }

    override fun onStart() {
        super.onStart()
        isActive = true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val fragment = supportFragmentManager.findFragmentById(R.id.subContainer)

        (fragment as BaseFragment<*, *>).onFragmentResult(requestCode, resultCode, data)

        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        val fragment = supportFragmentManager.findFragmentById(R.id.subContainer)

        (fragment as BaseFragment<*, *>).onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )

        when (requestCode) {
            RequestCodes.REQUEST_PERMISSION_READ_EXTERNAL_STORAGE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setupWallpaper()
                } else {

                }

            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(onDownloadComplete)
    }
    inner class Handler
}