package ch.galaxus.productfinder.features.products.scan.ui

import androidx.compose.runtime.*
import ch.galaxus.productfinder.compose.dialog.ErrorDialog
import ch.galaxus.productfinder.compose.resources.Strings
import ch.galaxus.productfinder.features.products.scan.util.BarcodeScanTexts

@Composable
fun PlayServicesNotInstalledErrorDialog(onOkayClick: () -> Unit) {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        ErrorDialog(
            title = Strings.ERROR,
            message = BarcodeScanTexts.ERROR_PLAY_SERVICES_NOT_INSTALLED,
            onClosed = {
                showDialog = false
                onOkayClick.invoke()
            }
        )
    }
}