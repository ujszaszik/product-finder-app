package ch.galaxus.productfinder.features.products.details.info.ui

import androidx.compose.runtime.Composable
import ch.galaxus.productfinder.compose.orientation.OrientationAwareScreen
import ch.galaxus.productfinder.features.products.details.info.model.ProductDetailsModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProductDetailsInfoScreen(itemDetails: ProductDetailsModel) {

    val pagerState = rememberPagerState()

    OrientationAwareScreen(
        portraitModeScreen = { ProductDetailsPortraitInfoScreen(itemDetails, pagerState) },
        landscapeModeScreen = { ProductDetailsLandscapeInfoScreen(itemDetails, pagerState) }
    )

}
