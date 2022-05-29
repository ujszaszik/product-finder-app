package ch.galaxus.productfinder.features.products.details.info.model

import ch.galaxus.productfinder.extension.empty
import ch.galaxus.productfinder.extension.zero
import ch.galaxus.productfinder.features.UiModel


data class ProductDetailsModel(
    val isEmpty: Boolean,
    val productId: Int,
    val brandName: String,
    val name: String,
    val nameProperties: String?,
    val imageUrls: List<String>,
    val price: ProductPrice
) : UiModel

fun emptyItemDetails(): ProductDetailsModel {
    return ProductDetailsModel(
        isEmpty = true,
        productId = 0,
        brandName = String.empty,
        name = String.empty,
        nameProperties = null,
        imageUrls = emptyList(),
        price = ProductPrice(Double.zero, String.empty)
    )
}