package ch.galaxus.barcodereader.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ch.galaxus.barcodereader.camera.CameraPreview
import ch.galaxus.barcodereader.resources.Dimens

@Composable
fun BarcodeReaderScreen(
    onDetection: (String) -> Unit,
    onError: (Throwable) -> Unit,
    onCancelled: () -> Unit,
    isFlashOn: Boolean = false,
    onFlashCLick: (Boolean) -> Unit
) {
    Column {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimens.marginHalf, horizontal = Dimens.marginDefault)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CancelImage(onClick = { onCancelled.invoke() })
            FlashImage(isFlashOn, onToggled = { onFlashCLick.invoke(it) })
        } // Row

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            CameraPreview(onDetection = onDetection, onError = onError)
            BarcodeTargetScreen(modifier = Modifier.align(Alignment.Center))
        } // Box

    } // Column
}