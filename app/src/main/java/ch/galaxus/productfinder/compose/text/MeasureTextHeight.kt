package ch.galaxus.productfinder.compose.text

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun MeasureTextHeight(fontSize: TextUnit, content: @Composable (height: Dp) -> Unit) {
    SubcomposeLayout { constraints ->
        val textHeight = subcompose(0) {
            Text(text = "Measure Text Height", fontSize = fontSize)
        }[0].measure(Constraints()).height.toDp()

        val contentPlaceable = subcompose(1) {
            content(textHeight)
        }[0].measure(constraints)
        layout(contentPlaceable.width, contentPlaceable.height) {
            contentPlaceable.place(0, 0)
        }
    }
}