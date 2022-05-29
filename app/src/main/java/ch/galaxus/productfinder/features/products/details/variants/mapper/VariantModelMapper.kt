package ch.galaxus.productfinder.features.products.details.variants.mapper

import ch.galaxus.productfinder.features.products.details.variants.domain.ProductVariants
import ch.galaxus.productfinder.features.products.details.variants.model.VariantModel

object VariantModelMapper {

    private const val URL_PREFIX = "https://static.digitecgalaxus.ch"

    fun map(variants: ProductVariants): List<VariantModel> {
        return variants
            .products
            .map {
                VariantModel(
                    productId = it.productId,
                    label = it.label,
                    imageUrl = "$URL_PREFIX${it.imageUrl}"
                )
            }
    }
}