package ch.galaxus.productfinder.features.products.details.variants.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import ch.galaxus.productfinder.compose.dialog.ErrorDialog
import ch.galaxus.productfinder.compose.progress.ProgressBar
import ch.galaxus.productfinder.compose.resources.Strings
import ch.galaxus.productfinder.coroutines.collectAsStateValue
import ch.galaxus.productfinder.features.products.details.common.ui.ProductDetailsEmptyScreen

@Composable
fun ProductVariantsScreen(productId: Int, viewModel: ProductVariantsViewModel = hiltViewModel()) {

    LaunchedEffect(productId) {
        viewModel.getProductVariants(productId)
    }

    val isLoading = viewModel.isLoading.collectAsStateValue() ?: false
    val productVariants = viewModel.productVariants.collectAsStateValue()
    val errorMessage = viewModel.errorMessage.collectAsStateValue()

    errorMessage?.let { ErrorDialog(title = Strings.ERROR, message = it) }

    val emptyVariants = true == productVariants?.variants?.isEmpty()

    when {
        isLoading -> ProgressBar()
        emptyVariants -> ProductDetailsEmptyScreen(ProductVariantsTexts.EMPTY_VARIANTS)
        productVariants != null -> ProductVariantsListScreen(productVariants)
        else -> ProgressBar()
    }

}