package ch.galaxus.productfinder.features.products.details.accessories.model

import ch.galaxus.productfinder.features.UiModel
import ch.galaxus.productfinder.features.products.details.info.model.ProductPrice

data class ProductAccessoriesModel(
    val accessories: List<ProductAccessoryModel>
) : UiModel

data class ProductAccessoryModel(
    val productId: Int,
    val brandName: String,
    val name: String,
    val price: ProductPrice,
    val imageUrl: String
)