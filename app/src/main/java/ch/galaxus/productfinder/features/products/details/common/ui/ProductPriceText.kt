package ch.galaxus.productfinder.features.products.details.common.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import ch.galaxus.productfinder.compose.resources.Colors
import ch.galaxus.productfinder.compose.resources.Dimens
import ch.galaxus.productfinder.compose.resources.Fonts
import ch.galaxus.productfinder.extension.asCurrency

@Composable
fun ProductPriceText(
    price: Double,
    fontSize: TextUnit
) {

    Text(
        modifier = Modifier.padding(Dimens.paddingDefault),
        text = price.asCurrency,
        color = Colors.black,
        fontFamily = Fonts.slateProFamily,
        fontWeight = FontWeight.Bold,
        fontSize = fontSize
    )
}