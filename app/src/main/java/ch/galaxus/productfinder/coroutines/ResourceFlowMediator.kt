package ch.galaxus.productfinder.coroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ch.galaxus.productfinder.features.UiModel
import ch.galaxus.productfinder.network.Resource
import ch.galaxus.productfinder.network.ResourceFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ResourceFlowMediator<Source : UiModel>(
    private val source: ResourceFlow<Source>,
    private val viewModel: ViewModel,
    private val loadingFlow: MutableStateFlow<Boolean?>,
    private val onSuccess: (Source) -> Unit,
    private val onError: (String) -> Unit
) {

    fun begin() {
        viewModel.viewModelScope.launch {
            source.collect { resource ->
                when (resource) {
                    is Resource.Loading -> doOnLoading()
                    is Resource.Success -> doOnSuccess(resource)
                    is Resource.Error -> doOnError(resource)
                }
            }
        }
    }

    private fun doOnLoading() = viewModel.launch { loadingFlow.emit(true) }

    private fun doOnSuccess(resource: Resource.Success<Source>) {
        viewModel.launch {
            loadingFlow.emit(false)
            resource.data.let { onSuccess.invoke(it) }
        }
    }

    private fun doOnError(resource: Resource.Error<Source>) {
        viewModel.launch {
            loadingFlow.emit(false)
            val errorMessage = resource.message
            onError.invoke(errorMessage)
        }
    }
}