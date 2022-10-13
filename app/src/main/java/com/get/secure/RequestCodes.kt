package com.get.secure

import java.io.Serializable

object RequestCodes : Serializable {
    const val PICK_IMAGE_CODE = 1
    const val PICK_FILE_CODE = 2
    const val PICK_CAMERA_CODE = 7
    const val REQUEST_PERMISSION_EXTERNAL_READ_IMAGE = 3
    const val REQUEST_PERMISSION_EXTERNAL_READ_FILE = 4
    const val REQUEST_PERMISSION_EXTERNAL_WRITE_FILE = 5
    const val REQUEST_PERMISSION_EXTERNAL_WRITE_FILE_FOR_CAMERA = 8
    const val REQUEST_PERMISSION_CAMERA = 6

}