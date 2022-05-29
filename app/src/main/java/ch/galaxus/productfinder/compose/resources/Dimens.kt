package ch.galaxus.productfinder.compose.resources

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Dimens {

    // PADDING
    val paddingLarge = 32.dp
    val paddingDouble = 16.dp
    val paddingDefault = 8.dp
    val paddingHalf = 4.dp

    private val paddingDefaultHorizontal = 20.dp
    private val paddingDefaultVertical = 12.dp
    val paddingDefaultValues = PaddingValues(
        start = paddingDefaultHorizontal,
        top = paddingDefaultVertical,
        end = paddingDefaultHorizontal,
        bottom = paddingDefaultVertical
    )

    // BORDER
    val defaultBorderWidth = 1.dp

    // SEPARATOR
    val defaultSeparatorSize = 1.dp

    // FLOW ROW
    val flowRowDefaultHeight = 30.dp

    // TEXT
    val smallTextSize = 13.sp
    val defaultTextSize = 15.sp
    val highlightTextSize = 16.sp
    val titleTextSize = 20.sp
    val emptyScreenTextSize = 24.sp
    val productInfoTextSize = 28.sp
    val productPriceTextSize = 32.sp
    val splashFontSize = 32.sp

    // ICON
    val largerIconSize = 24.dp
    val alertDialogIconSize = 40.dp
    val emptyListIconSize = 240.dp
}