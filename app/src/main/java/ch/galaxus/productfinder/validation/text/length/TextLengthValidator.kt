package ch.galaxus.productfinder.validation.text.length

import ch.galaxus.productfinder.validation.text.TextValidator

class TextLengthValidator(private val range: TextLengthRange) : TextValidator {

    override fun isValid(value: String?): Boolean {
        return value?.let {
            when (it.length) {
                in range.start..range.end -> true
                else -> false
            }
        } ?: false
    }
}