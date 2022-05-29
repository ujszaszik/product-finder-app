package ch.galaxus.productfinder.features.products.details.common.ui

import androidx.compose.runtime.Composable
import ch.galaxus.productfinder.compose.tab.TabScreen
import ch.galaxus.productfinder.compose.tab.TabScreenInfo
import ch.galaxus.productfinder.features.products.details.accessories.ui.ProductAccessoriesScreen
import ch.galaxus.productfinder.features.products.details.common.ProductTexts
import ch.galaxus.productfinder.features.products.details.info.model.ProductDetailsModel
import ch.galaxus.productfinder.features.products.details.info.ui.ProductDetailsInfoScreen
import ch.galaxus.productfinder.features.products.details.variants.ui.ProductVariantsScreen

@Composable
fun ProductDetailsScreen(itemDetails: ProductDetailsModel) {

    val screens = listOf(
        TabScreenInfo(
            label = ProductTexts.TITLE_MAIN_SCREEN,
            screen = { ProductDetailsInfoScreen(itemDetails) }
        ),
        TabScreenInfo(
            label = ProductTexts.TITLE_VARIANTS_SCREEN,
            screen = { ProductVariantsScreen(itemDetails.productId) }
        ),
        TabScreenInfo(
            label = ProductTexts.TITLE_ACCESSORIES_SCREEN,
            screen = { ProductAccessoriesScreen(itemDetails.productId) }
        )
    )

    TabScreen(screens)
}