package ch.galaxus.productfinder.features.products.scan.ui

import androidx.lifecycle.ViewModel
import ch.galaxus.barcodereader.camera.CameraHolder
import ch.galaxus.productfinder.coroutines.launch
import ch.galaxus.productfinder.coroutines.mutableStateFlow
import ch.galaxus.productfinder.features.products.scan.util.EanCodeAdjuster
import ch.galaxus.productfinder.features.products.scan.util.EanCodeValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class BarcodeScanViewModel @Inject constructor() : ViewModel() {

    internal val parsedEanCode = mutableStateFlow<String>()

    internal val error = mutableStateFlow<Boolean>()

    internal val isFlashTurnedOn = MutableStateFlow(false)

    internal fun toggleFlash() = launch {
        CameraHolder.setTorch(!isFlashTurnedOn.value)
        isFlashTurnedOn.emit(!isFlashTurnedOn.value)
    }

    internal fun acceptBarCode(rawValue: String?) {
        launch {
            val adjustedValue = EanCodeAdjuster.adjust(rawValue)
            if (EanCodeValidator.isValid(adjustedValue)) {
                parsedEanCode.emit(adjustedValue)
            } else error.emit(true)
        }
    }

}