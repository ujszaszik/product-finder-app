package ch.galaxus.productfinder.features.products.details.info.mapper

import ch.galaxus.productfinder.features.products.details.info.domain.ProductDetailsResponse
import ch.galaxus.productfinder.features.products.details.info.model.ProductDetailsModel
import ch.galaxus.productfinder.features.products.details.info.model.emptyItemDetails

object ProductDetailsMapper {

    fun map(response: ProductDetailsResponse): ProductDetailsModel {

        val result = response.data.search.products.results.firstOrNull()

        return result?.let {
            ProductDetailsModel(
                isEmpty = false,
                productId = it.product.productId,
                brandName = it.product.brandName,
                name = it.product.name,
                nameProperties = it.product.nameProperties,
                imageUrls = it.product.images.map { image -> image.url },
                price = ProductPriceMapper.map(it.offer)
            )
        } ?: emptyItemDetails()
    }
}