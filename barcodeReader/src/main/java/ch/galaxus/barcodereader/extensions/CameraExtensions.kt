package ch.galaxus.barcodereader.extensions

import android.content.pm.PackageManager

val PackageManager.hasFrontCamera: Boolean
    get() = hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)

val PackageManager.hasRearCamera: Boolean
    get() = hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)