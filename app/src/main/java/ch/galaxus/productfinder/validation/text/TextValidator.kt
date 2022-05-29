package ch.galaxus.productfinder.validation.text

import ch.galaxus.productfinder.extension.empty
import ch.galaxus.productfinder.validation.Validator

interface TextValidator : Validator<String?> {

    val errorMessage: String
        get() = String.empty
}