package ch.galaxus.productfinder.extension

val Number.asCurrency: String
    get() = "${this.toInt()}.-"

val Double.Companion.zero
    get() = 0.0