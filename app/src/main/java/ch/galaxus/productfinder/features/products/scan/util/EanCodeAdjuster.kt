package ch.galaxus.productfinder.features.products.scan.util

/**
 * Sometimes reading an EAN code, which starts with '0',
 * the Scanner only scans the numbers after '0'
 */
object EanCodeAdjuster {

    private const val ADJUSTABLE_LENGTH = 12
    private const val ADJUST_PREFIX = "0"

    fun adjust(rawValue: String?): String? {
        return if (rawValue?.length == ADJUSTABLE_LENGTH) {
            "$ADJUST_PREFIX$rawValue"
        } else rawValue
    }

}