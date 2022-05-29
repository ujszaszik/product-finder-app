package ch.galaxus.productfinder.compose.resources

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import ch.galaxus.productfinder.R

object Fonts {

    val slateProFamily = FontFamily(
        Font(R.font.slate_pro_light),
        Font(R.font.slate_pro_bold, weight = FontWeight.Bold)
    )
}