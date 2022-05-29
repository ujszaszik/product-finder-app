package ch.galaxus.productfinder.features.products.details.accessories.ui

import androidx.lifecycle.ViewModel
import ch.galaxus.productfinder.coroutines.ResourceFlowMediator
import ch.galaxus.productfinder.coroutines.emitValue
import ch.galaxus.productfinder.coroutines.mutableStateFlow
import ch.galaxus.productfinder.features.products.details.accessories.domain.GetPopularAccessoriesUseCase
import ch.galaxus.productfinder.features.products.details.accessories.model.ProductAccessoriesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProductAccessoriesViewModel @Inject constructor(
    private val accessoriesUseCase: GetPopularAccessoriesUseCase
) : ViewModel() {

    private var lastFetchedProductId = 0

    private val _isLoading = mutableStateFlow<Boolean>()
    val isLoading: StateFlow<Boolean?> = _isLoading

    private val _productAccessories = mutableStateFlow<ProductAccessoriesModel>()
    val productAccessories: StateFlow<ProductAccessoriesModel?> = _productAccessories

    private val _errorMessage = mutableStateFlow<String>()
    val errorMessage: StateFlow<String?> = _errorMessage

    fun getProductAccessories(productId: Int) {
        if (needsToFetch(productId)) {
            ResourceFlowMediator(
                source = accessoriesUseCase(productId),
                viewModel = this,
                loadingFlow = _isLoading,
                onSuccess = { emitValue(_productAccessories, it) },
                onError = { emitValue(_errorMessage, it) }
            ).begin()
            lastFetchedProductId = productId
        }
    }

    private fun needsToFetch(productId: Int): Boolean {
        return lastFetchedProductId != productId
    }

}