package ch.galaxus.productfinder.features.products.details.accessories.mapper

import ch.galaxus.productfinder.extension.empty
import ch.galaxus.productfinder.features.products.details.accessories.model.ProductAccessoriesModel
import ch.galaxus.productfinder.features.products.details.accessories.model.ProductAccessoryModel
import ch.galaxus.productfinder.features.products.details.info.mapper.ProductPriceMapper
import ch.galaxus.productfinder.features.products.details.common.domain.ProductListResponse

object ProductAccessoriesMapper {

    fun map(response: ProductListResponse): ProductAccessoriesModel {
        return ProductAccessoriesModel(
            accessories = response.data.productsWithOfferDefault.products.map {
                ProductAccessoryModel(
                    productId = it.product.productId,
                    brandName = it.product.brandName,
                    name = it.product.name,
                    price = ProductPriceMapper.map(it.offer),
                    imageUrl = it.product.images.firstOrNull()?.url ?: String.empty
                )
            }
        )
    }
}