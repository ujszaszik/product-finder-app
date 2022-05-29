package ch.galaxus.productfinder.validation.text.content

import ch.galaxus.productfinder.validation.text.TextValidator

class TextContentValidator(private val allowedChars: List<Char>) : TextValidator {

    override fun isValid(value: String?): Boolean {
        return value?.all { char ->
            char in allowedChars
        } ?: false
    }
}
