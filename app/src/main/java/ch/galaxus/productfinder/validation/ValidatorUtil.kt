package ch.galaxus.productfinder.validation

fun <T> isValidForAll(type: T?, vararg validators: Validator<T?>): Boolean {
    return validators.all { it.isValid(type) }
}

fun <T> isValidForAny(type: T?, vararg validators: Validator<T?>): Boolean {
    return validators.any { it.isValid(type) }
}