package ch.galaxus.barcodereader.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.Modifier

fun Modifier.clickable(
    onClick: () -> Unit,
    rippleEffect: Boolean = true
): Modifier =
    when (rippleEffect) {
        true -> clickable(onClick = onClick)
        false -> {
            clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = onClick
            )
        }
    }