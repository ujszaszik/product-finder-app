package ch.galaxus.productfinder.features.main.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import ch.galaxus.productfinder.compose.layout.DoubleSpacer
import ch.galaxus.productfinder.compose.resources.Colors
import ch.galaxus.productfinder.compose.resources.Dimens
import ch.galaxus.productfinder.compose.resources.Fonts
import ch.galaxus.productfinder.compose.resources.Images

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.white),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Images.GalaxusLogo()

        DoubleSpacer()

        Text(
            text = SplashTexts.APP_TITLE,
            color = Colors.primary,
            fontWeight = FontWeight.Bold,
            fontFamily = Fonts.slateProFamily,
            fontSize = Dimens.splashFontSize
        )

    }
}