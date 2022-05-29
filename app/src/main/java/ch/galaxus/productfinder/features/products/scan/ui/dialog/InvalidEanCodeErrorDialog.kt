package ch.galaxus.productfinder.features.products.scan.ui.dialog

import androidx.compose.runtime.*
import ch.galaxus.productfinder.compose.dialog.ErrorDialog
import ch.galaxus.productfinder.compose.resources.Strings
import ch.galaxus.productfinder.features.products.scan.util.BarcodeScanTexts

@Composable
fun InvalidEanCodeErrorDialog(onOkayClick: () -> Unit) {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        ErrorDialog(
            title = Strings.ERROR,
            message = BarcodeScanTexts.ERROR_INVALID_EAN_CODE,
            onClosed = {
                showDialog = false
                onOkayClick.invoke()
            }
        )
    }
}