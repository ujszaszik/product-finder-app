package ch.galaxus.barcodereader.camera

import androidx.camera.core.Camera

object CameraHolder {
    var camera: Camera? = null

    fun setTorch(value: Boolean) = camera?.cameraControl?.enableTorch(value)
}