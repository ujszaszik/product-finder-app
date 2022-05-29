package ch.galaxus.productfinder.compose.progress

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ch.galaxus.productfinder.R
import ch.galaxus.productfinder.compose.layout.CenteredColumn
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun ProgressBar(modifier: Modifier = Modifier) {
    CenteredColumn(modifier = modifier) {
        val lottieSpec = LottieCompositionSpec.RawRes(R.raw.progress_bar)
        val composition by rememberLottieComposition(lottieSpec)
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever
        )
    }
}