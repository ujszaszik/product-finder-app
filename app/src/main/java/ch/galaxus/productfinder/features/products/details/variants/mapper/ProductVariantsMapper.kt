package ch.galaxus.productfinder.features.products.details.variants.mapper

import ch.galaxus.productfinder.features.products.details.variants.domain.ProductVariantResponse
import ch.galaxus.productfinder.features.products.details.variants.model.ProductVariantsModel
import ch.galaxus.productfinder.features.products.details.variants.model.VariantDimension
import ch.galaxus.productfinder.features.products.details.variants.model.VariantType

object ProductVariantsMapper {

    fun map(response: ProductVariantResponse): ProductVariantsModel {
        val variants = response.data.productDetailsV3.productDetails.variants
        return ProductVariantsModel(
            variants = variants.map {
                VariantDimension(
                    name = it.name,
                    type = VariantType.valueOf(it.type),
                    variants = VariantModelMapper.map(it)
                )
            }
        )
    }
}