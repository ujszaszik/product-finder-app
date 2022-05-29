package ch.galaxus.productfinder.features.products.details.common.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ch.galaxus.productfinder.compose.dialog.ErrorDialog
import ch.galaxus.productfinder.compose.progress.ProgressBar
import ch.galaxus.productfinder.compose.resources.Strings
import ch.galaxus.productfinder.coroutines.collectAsStateValue
import ch.galaxus.productfinder.features.products.details.info.ui.ProductDetailsInfoViewModel
import ch.galaxus.productfinder.features.products.search.ProductSearchHost
import ch.galaxus.productfinder.navigation.graph.LocalNavController
import ch.galaxus.productfinder.navigation.host.BackPressStrategy
import ch.galaxus.productfinder.navigation.host.Host
import ch.galaxus.productfinder.navigation.host.acceptParam

const val PRODUCT_DETAILS_KEY = "ProductDetails::EanCode"

val ProductDetailsHost = Host(
    route = "Product Search",
    backPressStrategy = BackPressStrategy.GO_TO_MAIN_SCREEN
).acceptParam(PRODUCT_DETAILS_KEY)

@Composable
fun ProductDetailsHost(eanCode: String?, viewModel: ProductDetailsInfoViewModel = hiltViewModel()) {

    val navController = LocalNavController.current

    LaunchedEffect(eanCode) {
        eanCode?.let {
            viewModel.getItemDetails(it)
        }
    }

    val isLoading = viewModel.isLoading.collectAsStateValue() ?: false
    val itemDetails = viewModel.itemDetails.collectAsStateValue()
    val errorMessage = viewModel.errorMessage.collectAsStateValue()

    errorMessage?.let { ErrorDialog(title = Strings.ERROR, message = it) }

    when {
        isLoading -> ProgressBar()
        itemDetails != null && !itemDetails.isEmpty -> ProductDetailsScreen(itemDetails)
        itemDetails != null && itemDetails.isEmpty -> {
            ProductNotFoundDialog { navController.navigate(ProductSearchHost.route) }
        }
        else -> ProgressBar()
    }
}