package ch.galaxus.productfinder.features.products.scan.util

import ch.galaxus.productfinder.validation.isValidForAll
import ch.galaxus.productfinder.validation.text.TextValidator
import ch.galaxus.productfinder.validation.text.content.TextContentValidator
import ch.galaxus.productfinder.validation.text.length.TextLengthRange
import ch.galaxus.productfinder.validation.text.length.TextLengthValidator

object EanCodeValidator : TextValidator {

    private val allowedChars = listOf('0'..'9').flatten()
    private val contentValidator = TextContentValidator(allowedChars)

    private const val ALLOWED_CHARS = 13
    private val allowedLengthRange = TextLengthRange.of(ALLOWED_CHARS, ALLOWED_CHARS)
    private val lengthValidator = TextLengthValidator(allowedLengthRange)

    override val errorMessage: String
        get() = "Muss eine 13-stellige Zahl sein."

    override fun isValid(value: String?): Boolean {
        return value?.let {
            isValidForAll(it, contentValidator, lengthValidator)
        } ?: false
    }
}