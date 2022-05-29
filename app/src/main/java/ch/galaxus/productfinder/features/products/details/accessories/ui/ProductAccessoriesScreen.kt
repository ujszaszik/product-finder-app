package ch.galaxus.productfinder.features.products.details.accessories.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ch.galaxus.productfinder.compose.dialog.ErrorDialog
import ch.galaxus.productfinder.compose.progress.ProgressBar
import ch.galaxus.productfinder.compose.resources.Strings
import ch.galaxus.productfinder.coroutines.collectAsStateValue
import ch.galaxus.productfinder.features.products.details.common.ui.ProductDetailsEmptyScreen

@Composable
fun ProductAccessoriesScreen(
    productId: Int,
    viewModel: ProductAccessoriesViewModel = hiltViewModel()
) {

    LaunchedEffect(productId) {
        viewModel.getProductAccessories(productId)
    }

    val isLoading = viewModel.isLoading.collectAsStateValue() ?: false
    val productAccessories = viewModel.productAccessories.collectAsStateValue()
    val errorMessage = viewModel.errorMessage.collectAsStateValue()

    errorMessage?.let { ErrorDialog(title = Strings.ERROR, message = it) }

    val emptyAccessories = true == productAccessories?.accessories?.isEmpty()

    when {
        isLoading -> ProgressBar()
        emptyAccessories -> ProductDetailsEmptyScreen(ProductAccessoriesTexts.EMPTY_ACCESSORIES)
        productAccessories != null -> ProductAccessoriesListScreen(productAccessories)
        else -> ProgressBar()
    }

}