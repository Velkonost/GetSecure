package com.get.secure

import java.io.Serializable

object RequestCodes : Serializable {
    const val REQUEST_PERMISSION_READ_EXTERNAL_STORAGE = 1
    const val REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE = 2
    const val REQUEST_PERMISSION_CAMERA = 3
}