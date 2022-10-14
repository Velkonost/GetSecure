package com.get.secure.util

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import com.get.secure.RequestCodes
import com.get.secure.ui.activity.main.MainActivity

fun MainActivity.checkPermissionForReadExternalStorage(): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if ((ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_DENIED)
        ) {
            val permission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)

            this.requestPermissions(
                permission,
                RequestCodes.REQUEST_PERMISSION_READ_EXTERNAL_STORAGE
            )

            return false
        } else {
            return true
        }
    } else return true
}

fun MainActivity.checkPermissionForWriteExternalStorage(): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if ((ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_DENIED)
        ) {
            val permission = arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE)

            this.requestPermissions(
                permission,
                RequestCodes.REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE
            )

            return false
        } else {
            return true
        }
    } else return true
}

fun MainActivity.checkPermissionForCamera(): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if ((ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_DENIED)
        ) {
            val permission = arrayOf(Manifest.permission.CAMERA)

            this.requestPermissions(
                permission,
                RequestCodes.REQUEST_PERMISSION_CAMERA
            )

            return false
        } else {
            return true
        }
    } else return true
}