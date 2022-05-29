package ch.galaxus.productfinder.features.products.search

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import ch.galaxus.productfinder.compose.button.PrimaryButton
import ch.galaxus.productfinder.compose.button.SecondaryButton
import ch.galaxus.productfinder.compose.input.InputField
import ch.galaxus.productfinder.compose.keyboard.KeyboardStyle
import ch.galaxus.productfinder.compose.layout.CenteredColumn
import ch.galaxus.productfinder.compose.layout.DoubleSpacer
import ch.galaxus.productfinder.features.main.util.LocalKeyboardManager

@Composable
fun ProductSearchScreen(
    errorMessage: String? = null,
    onTextChanged: (String) -> Unit,
    onSearchRequested: () -> Unit,
    onBarcodeScanRequest: () -> Unit
) {

    val keyboardManager = LocalKeyboardManager.current

    CenteredColumn {

        InputField(
            label = ProductSearchTexts.SEARCH_HINT,
            errorMessage = errorMessage,
            onTextChanged = { onTextChanged(it) },
            keyboardStyle = KeyboardStyle.NUMERIC
        )

        PrimaryButton(
            label = ProductSearchTexts.SEARCH_BUTTON_LABEL,
            onClick = {
                keyboardManager.hide()
                onSearchRequested()
            },
            icon = Icons.Default.Search
        )

        DoubleSpacer()

        SecondaryButton(
            label = ProductSearchTexts.BARCODE_BUTTON_LABEL,
            onClick = {
                keyboardManager.hide()
                onBarcodeScanRequest()
            },
            icon = Icons.Default.QrCode
        )
    }
}