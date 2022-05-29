package ch.galaxus.barcodereader.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import ch.galaxus.barcodereader.extensions.clickable
import ch.galaxus.barcodereader.resources.Dimens

@Composable
fun FlashImage(
    isTurnedOn: Boolean,
    onToggled: (Boolean) -> Unit
) {
    val image = if (isTurnedOn) Icons.Default.FlashOff else Icons.Default.FlashOn

    Image(
        imageVector = image,
        colorFilter = ColorFilter.tint(Color.Black),
        contentDescription = "",
        modifier = Modifier
            .clickable(onClick = { onToggled.invoke(isTurnedOn) }, rippleEffect = false)
            .size(Dimens.flashImageSize)
    )
}