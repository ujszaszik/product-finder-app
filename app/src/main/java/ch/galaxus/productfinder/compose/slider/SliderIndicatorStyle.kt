package ch.galaxus.productfinder.compose.slider

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ch.galaxus.productfinder.compose.resources.Colors

open class SliderIndicatorStyle {
    open val highlightColor: Color = Colors.black
    open val highlightAlpha = 1.0f
    open val defaultColor: Color = Colors.black
    open val defaultAlpha: Float = 0.3f
    open val horizontalPadding = 8.dp
    open val indicatorSize = 20.dp
    open val indicatorRadius = 12F
}