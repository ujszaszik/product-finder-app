package ch.galaxus.productfinder.features.products.details.common.repository

import ch.galaxus.productfinder.features.products.details.accessories.domain.ItemAccessoriesResponse
import ch.galaxus.productfinder.features.products.details.info.domain.ProductDetailsResponse
import ch.galaxus.productfinder.features.products.details.common.domain.ProductListResponse
import ch.galaxus.productfinder.features.products.details.variants.domain.ProductVariantResponse
import ch.galaxus.productfinder.network.ResourceFlow

interface IProductRepository {

    fun getDetails(eanCode: String): ResourceFlow<ProductDetailsResponse>

    fun getAccessories(productId: Int): ResourceFlow<ItemAccessoriesResponse>

    fun getProductsList(productIds: List<Int>): ResourceFlow<ProductListResponse>

    fun getVariants(productId: Int): ResourceFlow<ProductVariantResponse>
}