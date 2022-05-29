package ch.galaxus.productfinder.coroutines

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ch.galaxus.productfinder.network.Resource
import ch.galaxus.productfinder.network.ResourceFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch


fun ViewModel.launch(block: suspend () -> Unit) {
    viewModelScope.launch { block() }
}

fun <T> mutableStateFlow() = MutableStateFlow<T?>(null)

fun <T> ViewModel.emitValue(flow: MutableStateFlow<T?>, value: T?) {
    launch { flow.emit(value) }
}

fun <T> ViewModel.emitEvent(flow: SingleEventFlow<T>, value: T?) {
    launch { flow.emit(value) }
}

@Composable
fun <T> Flow<T>.collectAsStateValue(): T? {
    return collectAsState(initial = null).value
}

fun <T> MutableStateFlow<T?>.clear() {
    this.value = null
}

fun <T : Any, R : Any> ResourceFlow<T>.mapResource(mapper: (T) -> R): ResourceFlow<R> {
    return map {
        when (it) {
            is Resource.Success -> Resource.Success(mapper(it.data))
            is Resource.Error -> Resource.Error(it.message)
            is Resource.Loading -> Resource.Loading()
        }
    }
}

fun <T : Any, R : Any, S : Any> ResourceFlow<T>.chainResource(
    mapper: (T) -> R,
    trigger: (R) -> ResourceFlow<S>
): ResourceFlow<S> {
    return mapResource { mapper(it) }
        .transform { mapped ->
            if (mapped is Resource.Success) {
                trigger(mapped.data).collect { result -> emit(result) }
            }
        }
}