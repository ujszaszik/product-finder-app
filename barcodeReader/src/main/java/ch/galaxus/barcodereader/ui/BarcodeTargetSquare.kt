package ch.galaxus.barcodereader.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import ch.galaxus.barcodereader.R
import ch.galaxus.barcodereader.resources.Strings

@Composable
fun BarcodeTargetScreen(modifier: Modifier = Modifier) {

    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_barcode_frame),
        contentDescription = Strings.QR_TARGET_SQUARE
    )
}