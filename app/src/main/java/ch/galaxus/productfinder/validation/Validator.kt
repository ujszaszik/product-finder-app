package ch.galaxus.productfinder.validation

interface Validator<Type> {

    fun isValid(value: Type): Boolean
}