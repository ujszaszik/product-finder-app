package ch.galaxus.productfinder.features.products.details.variants.model

import ch.galaxus.productfinder.features.UiModel

data class ProductVariantsModel(
    val variants: List<VariantDimension>
) : UiModel

data class VariantDimension(
    val name: String,
    val type: VariantType,
    val variants: List<VariantModel>
)

data class VariantModel(
    val productId: Int,
    val label: String,
    val imageUrl: String = ""
)

enum class VariantType(val screenRatio: Float) {
    IMAGE(0.4F),
    TEXT(0.3F);

    fun isImage() = this == IMAGE
}