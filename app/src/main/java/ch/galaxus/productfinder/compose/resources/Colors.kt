package ch.galaxus.productfinder.compose.resources

import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object Colors {

    val primary = Color(0xFF444444)

    val white = Color(0xFFFFFFFF)
    val black = Color(0xFF000000)
    val red = Color(0xFFFF6917)
    val gray = Color(0xFFC1C1C1)
    val steelGray = Color(0xFF767676)

    @Composable
    fun inputFieldColors() = TextFieldDefaults.textFieldColors(
        textColor = primary,
        disabledTextColor = gray,
        focusedLabelColor = steelGray,
        unfocusedLabelColor = steelGray,
        focusedIndicatorColor = primary,
        unfocusedIndicatorColor = gray
    )
}