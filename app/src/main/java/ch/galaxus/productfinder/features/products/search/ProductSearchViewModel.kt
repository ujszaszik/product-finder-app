package ch.galaxus.productfinder.features.products.search

import androidx.lifecycle.ViewModel
import ch.galaxus.productfinder.coroutines.InputFlow
import ch.galaxus.productfinder.coroutines.clear
import ch.galaxus.productfinder.coroutines.launch
import ch.galaxus.productfinder.coroutines.mutableStateFlow
import ch.galaxus.productfinder.features.products.scan.util.EanCodeValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProductSearchViewModel @Inject constructor() : ViewModel() {

    internal var searchedCodeInput = InputFlow(EanCodeValidator)

    private val _searchedEanCode = mutableStateFlow<String>()
    val searchedEanCode: StateFlow<String?> = _searchedEanCode

    fun onSearchTextChange(newValue: String) {
        searchedCodeInput.onValueChanged(newValue)
    }

    fun onSearchRequest() {
        if (searchedCodeInput.isValid()) {
            launch { _searchedEanCode.emit(searchedCodeInput.actualValue()) }
        }
    }

    fun resetKeyword() = _searchedEanCode.clear()

}