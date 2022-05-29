package ch.galaxus.productfinder.compose.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import ch.galaxus.productfinder.compose.resources.Colors

@Composable
fun PrimaryButton(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    DefaultButton(
        label = label,
        backgroundColor = Colors.primary,
        textColor = Colors.white,
        icon = icon,
        iconTint = Colors.white,
        onClick = onClick
    )
}