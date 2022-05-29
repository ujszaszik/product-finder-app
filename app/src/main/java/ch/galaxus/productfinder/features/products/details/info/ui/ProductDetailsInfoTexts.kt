package ch.galaxus.productfinder.features.products.details.info.ui

object ProductDetailsInfoTexts {

    private const val IMAGE_AMOUNT_POSTFIX = "Bilder"

    internal fun imageAmountText(amount: Int): String {
        return "$amount $IMAGE_AMOUNT_POSTFIX"
    }
}