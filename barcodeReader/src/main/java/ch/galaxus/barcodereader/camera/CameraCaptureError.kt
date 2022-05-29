package ch.galaxus.barcodereader.camera

import ch.galaxus.barcodereader.resources.Strings

interface CameraCaptureError {
    val message: String?
}

class LowStorageError : Throwable(message = Strings.ERROR_LOW_STORAGE), CameraCaptureError

class CameraMissingError : Throwable(message = Strings.ERROR_CAMERA_MISSING), CameraCaptureError

object CameraInitError : Throwable(message = Strings.ERROR_CAMERA_INIT), CameraCaptureError