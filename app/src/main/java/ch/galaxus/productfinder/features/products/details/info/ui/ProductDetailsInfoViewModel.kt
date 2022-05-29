package ch.galaxus.productfinder.features.products.details.info.ui

import androidx.lifecycle.ViewModel
import ch.galaxus.productfinder.coroutines.ResourceFlowMediator
import ch.galaxus.productfinder.coroutines.emitValue
import ch.galaxus.productfinder.coroutines.mutableStateFlow
import ch.galaxus.productfinder.features.products.details.info.domain.GetProductDetailsUseCase
import ch.galaxus.productfinder.features.products.details.info.model.ProductDetailsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProductDetailsInfoViewModel @Inject constructor(
    private val itemDetailsUseCase: GetProductDetailsUseCase,
) : ViewModel() {

    private val _isLoading = mutableStateFlow<Boolean>()
    val isLoading: StateFlow<Boolean?> = _isLoading

    private val _itemDetails = mutableStateFlow<ProductDetailsModel>()
    val itemDetails: StateFlow<ProductDetailsModel?> = _itemDetails

    private val _errorMessage = mutableStateFlow<String>()
    val errorMessage: StateFlow<String?> = _errorMessage

    fun getItemDetails(eanCode: String) {
        ResourceFlowMediator(
            source = itemDetailsUseCase(eanCode),
            viewModel = this,
            loadingFlow = _isLoading,
            onSuccess = { emitValue(_itemDetails, it) },
            onError = { emitValue(_errorMessage, it) }
        ).begin()
    }
}