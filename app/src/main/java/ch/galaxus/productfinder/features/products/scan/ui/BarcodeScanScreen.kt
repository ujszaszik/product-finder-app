package ch.galaxus.productfinder.features.products.scan.ui

import androidx.compose.runtime.*
import ch.galaxus.barcodereader.camera.CameraInitError
import ch.galaxus.barcodereader.camera.CameraMissingError
import ch.galaxus.barcodereader.camera.LowStorageError
import ch.galaxus.barcodereader.ui.BarcodeReaderScreen
import ch.galaxus.productfinder.compose.toast.LongToast

@Composable
fun BarcodeScanScreen(
    onDetection: (String) -> Unit,
    onCancel: () -> Unit,
    onToggleFlash: () -> Unit,
    isFlashOn: Boolean
) {


    var cameraError by remember { mutableStateOf<Throwable?>(null) }
    val errorMessage = when (cameraError) {
        is CameraMissingError, is LowStorageError -> cameraError?.message
        null -> null
        else -> CameraInitError.message
    }

    BarcodeReaderScreen(
        onDetection = {
            onDetection(it)
            println(":::::::DETECTED:::: $it")
        },
        onError = { cameraError = it },
        onCancelled = { onCancel() },
        onFlashCLick = { onToggleFlash() },
        isFlashOn = isFlashOn
    )

    LongToast(
        isVisible = errorMessage != null,
        message = errorMessage
    )

}