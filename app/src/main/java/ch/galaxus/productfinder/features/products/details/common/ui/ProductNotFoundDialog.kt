package ch.galaxus.productfinder.features.products.details.common.ui

import androidx.compose.runtime.Composable
import ch.galaxus.productfinder.compose.dialog.ErrorDialog
import ch.galaxus.productfinder.compose.resources.Strings
import ch.galaxus.productfinder.features.products.details.common.ProductTexts

@Composable
fun ProductNotFoundDialog(doOnClose: () -> Unit) {

    ErrorDialog(
        title = Strings.ERROR,
        message = ProductTexts.EAN_CODE_NOT_FOUND,
        onClosed = doOnClose
    )

}