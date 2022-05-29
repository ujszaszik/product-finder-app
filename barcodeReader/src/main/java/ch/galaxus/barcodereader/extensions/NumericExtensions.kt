package ch.galaxus.barcodereader.extensions

fun Number.lessOrEqualsThen(other: Number): Boolean {
    return this.toDouble() <= other.toDouble()
}