package ch.galaxus.productfinder.compose.keyboard

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

class KeyboardStyle(
    private val keyboardType: KeyboardType,
    private val imeAction: ImeAction = ImeAction.Default,
    private val keyboardAction: () -> Unit = {}
) {
    val keyboardOptions: KeyboardOptions
        get() = KeyboardOptions.Default.copy(keyboardType = keyboardType, imeAction = imeAction)

    val keyboardActions: KeyboardActions
        get() = when (imeAction) {
            ImeAction.Done -> KeyboardActions(onDone = { keyboardAction.invoke() })
            ImeAction.Go -> KeyboardActions(onGo = { keyboardAction.invoke() })
            ImeAction.Search -> KeyboardActions(onSearch = { keyboardAction.invoke() })
            ImeAction.Send -> KeyboardActions(onSend = { keyboardAction.invoke() })
            ImeAction.Previous -> KeyboardActions(onPrevious = { keyboardAction.invoke() })
            ImeAction.Next -> KeyboardActions(onNext = { keyboardAction.invoke() })
            else -> KeyboardActions.Default
        }

    companion object {
        val DEFAULT = KeyboardStyle(KeyboardType.Text)

        val NUMERIC = KeyboardStyle(KeyboardType.Number)
    }
}