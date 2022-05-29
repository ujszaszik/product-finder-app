package ch.galaxus.barcodereader.camera

import android.content.pm.PackageManager
import androidx.camera.core.CameraSelector
import androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA
import androidx.camera.core.CameraSelector.DEFAULT_FRONT_CAMERA
import ch.galaxus.barcodereader.extensions.hasFrontCamera
import ch.galaxus.barcodereader.extensions.hasRearCamera

object CameraFacingUtil {

    fun getSelector(packageManager: PackageManager): CameraSelector? {
        return when {
            packageManager.hasRearCamera -> DEFAULT_BACK_CAMERA
            packageManager.hasFrontCamera -> DEFAULT_FRONT_CAMERA
            else -> null
        }
    }
}