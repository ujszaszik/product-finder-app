package ch.galaxus.productfinder.features.products.details.variants.ui

import androidx.lifecycle.ViewModel
import ch.galaxus.productfinder.coroutines.ResourceFlowMediator
import ch.galaxus.productfinder.coroutines.emitValue
import ch.galaxus.productfinder.coroutines.mutableStateFlow
import ch.galaxus.productfinder.features.products.details.variants.domain.GetProductVariantsUseCase
import ch.galaxus.productfinder.features.products.details.variants.model.ProductVariantsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProductVariantsViewModel @Inject constructor(
    private val itemVariantsUseCase: GetProductVariantsUseCase
) : ViewModel() {

    private var lastFetchedProductId = 0

    private val _isLoading = mutableStateFlow<Boolean>()
    val isLoading: StateFlow<Boolean?> = _isLoading

    private val _productVariants = mutableStateFlow<ProductVariantsModel>()
    val productVariants: StateFlow<ProductVariantsModel?> = _productVariants

    private val _errorMessage = mutableStateFlow<String>()
    val errorMessage: StateFlow<String?> = _errorMessage

    fun getProductVariants(productId: Int) {
        if (needsToFetch(productId)) {
            ResourceFlowMediator(
                source = itemVariantsUseCase(productId),
                viewModel = this,
                loadingFlow = _isLoading,
                onSuccess = { emitValue(_productVariants, it) },
                onError = { emitValue(_errorMessage, it) }
            ).begin()
            lastFetchedProductId = productId
        }
    }

    private fun needsToFetch(productId: Int): Boolean {
        return lastFetchedProductId != productId
    }

}