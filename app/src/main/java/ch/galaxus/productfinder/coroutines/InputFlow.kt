package ch.galaxus.productfinder.coroutines

import androidx.compose.runtime.Composable
import ch.galaxus.productfinder.extension.empty
import ch.galaxus.productfinder.validation.text.TextValidator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class InputFlow(private val validator: TextValidator) : CoroutineScope {

    override val coroutineContext: CoroutineContext = Job()

    private var currentValue = String.empty
    private val inputError = mutableStateFlow<String>()

    fun onValueChanged(newValue: String) {
        if (newValue != currentValue) {
            currentValue = newValue
            inputError.value = null
        }
    }

    fun isValid(): Boolean {
        val isValidUsername = validator.isValid(currentValue)
        if (!isValidUsername) launch { inputError.emit(validator.errorMessage) }
        return isValidUsername
    }

    fun actualValue() = currentValue

    @Composable
    fun collectErrorState(): String? = inputError.collectAsStateValue()
}