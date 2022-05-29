package ch.galaxus.productfinder.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ch.galaxus.productfinder.features.main.splash.SplashHost
import ch.galaxus.productfinder.features.products.details.common.ui.PRODUCT_DETAILS_KEY
import ch.galaxus.productfinder.features.products.details.common.ui.ProductDetailsHost
import ch.galaxus.productfinder.features.products.scan.ui.BarcodeScanHost
import ch.galaxus.productfinder.features.products.search.ProductSearchHost
import ch.galaxus.productfinder.navigation.arguments.retainParam
import ch.galaxus.productfinder.navigation.composable

val LocalNavController =
    compositionLocalOf<NavHostController> { error("LocalComposition NavController not present") }

@Composable
fun ApplicationGraph() {

    val navController = LocalNavController.current

    NavHost(navController = navController, startDestination = SplashHost.route) {

        composable(SplashHost) {
            SplashHost()
        }

        composable(ProductSearchHost) {
            ProductSearchHost()
        }

        composable(BarcodeScanHost) {
            BarcodeScanHost()
        }

        composable(ProductDetailsHost) {
            val eanCode = it.retainParam<String>(PRODUCT_DETAILS_KEY)
            ProductDetailsHost(eanCode)
        }
    }
}