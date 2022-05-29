package ch.galaxus.productfinder.features.products.details.common.ui

import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import ch.galaxus.productfinder.compose.resources.Colors
import ch.galaxus.productfinder.compose.text.MeasureTextHeight

@Composable
fun ProductNameText(
    brandName: String,
    name: String,
    fontSize: TextUnit,
    needsMeasurement: Boolean,
    allowedLines: Int
) {

    MeasureTextHeight(fontSize) { textHeight ->

        var modifier: Modifier = Modifier

        if (needsMeasurement) {
            modifier = Modifier.height(textHeight * allowedLines)
        }

        Text(
            modifier = modifier,
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Colors.black,
                        fontSize = fontSize,
                        fontWeight = FontWeight.Bold
                    )
                ) { append("$brandName ") }
                withStyle(
                    style = SpanStyle(
                        color = Colors.black,
                        fontSize = fontSize
                    )
                ) { append(name) }
            },
            maxLines = allowedLines,
            overflow = TextOverflow.Ellipsis
        )

    }
}