package ch.galaxus.productfinder.compose.resources

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ch.galaxus.productfinder.R
import ch.galaxus.productfinder.extension.empty

object Images {

    @Composable
    fun GalaxusLogo() {
        Image(
            painter = painterResource(R.drawable.logo_galaxus),
            modifier = Modifier
                .width(120.dp)
                .height(120.dp),
            contentDescription = String.empty
        )
    }
}