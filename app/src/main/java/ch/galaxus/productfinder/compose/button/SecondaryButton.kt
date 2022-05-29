package ch.galaxus.productfinder.compose.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import ch.galaxus.productfinder.compose.resources.Colors

@Composable
fun SecondaryButton(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    DefaultButton(
        label = label,
        backgroundColor = Colors.white,
        textColor = Colors.primary,
        icon = icon,
        iconTint = Colors.primary,
        onClick = onClick
    )
}