package ch.galaxus.productfinder.features.products.details.common.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import ch.galaxus.productfinder.R
import ch.galaxus.productfinder.compose.layout.CenteredColumn
import ch.galaxus.productfinder.compose.layout.LargeSpacer
import ch.galaxus.productfinder.compose.resources.Colors
import ch.galaxus.productfinder.compose.resources.Dimens
import ch.galaxus.productfinder.compose.resources.Fonts
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay

private const val EMPTY_LIST_DELAY = 750L

@Composable
fun ProductDetailsEmptyScreen(
    message: String
) {

    var showScreen by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = showScreen) {
        delay(EMPTY_LIST_DELAY)
        showScreen = true
    }

    if (showScreen) {
        CenteredColumn(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.size(Dimens.emptyListIconSize)) {
                val lottieSpec = LottieCompositionSpec.RawRes(R.raw.empty_box)
                val composition by rememberLottieComposition(lottieSpec)
                LottieAnimation(
                    composition = composition,
                    iterations = 1
                )
            }

            LargeSpacer()

            Text(
                text = message,
                fontFamily = Fonts.slateProFamily,
                fontSize = Dimens.emptyScreenTextSize,
                color = Colors.black
            )
        }
    }

}