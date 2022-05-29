package ch.galaxus.productfinder.features.products.details.common.repository

import ch.galaxus.productfinder.features.products.details.accessories.domain.GetPopularAccessoriesQuery
import ch.galaxus.productfinder.features.products.details.accessories.domain.ItemAccessoriesResponse
import ch.galaxus.productfinder.features.products.details.info.domain.GetProductDetailsQuery
import ch.galaxus.productfinder.features.products.details.info.domain.ProductDetailsResponse
import ch.galaxus.productfinder.features.products.details.common.domain.ProductListQuery
import ch.galaxus.productfinder.features.products.details.common.domain.ProductListResponse
import ch.galaxus.productfinder.features.products.details.variants.domain.ProductVariantResponse
import ch.galaxus.productfinder.features.products.details.variants.domain.GetProductVariantsQuery
import ch.galaxus.productfinder.network.ResourceFlow
import ch.galaxus.productfinder.network.WebClient
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val webClient: WebClient
) : IProductRepository {

    override fun getDetails(eanCode: String): ResourceFlow<ProductDetailsResponse> {
        val query = GetProductDetailsQuery().build(eanCode)
        return webClient.postQuery(query)
    }

    override fun getAccessories(productId: Int): ResourceFlow<ItemAccessoriesResponse> {
        val query = GetPopularAccessoriesQuery().build(productId)
        return webClient.postQuery(query)
    }

    override fun getProductsList(productIds: List<Int>): ResourceFlow<ProductListResponse> {
        val query = ProductListQuery().build(productIds)
        return webClient.postQuery(query)
    }

    override fun getVariants(productId: Int): ResourceFlow<ProductVariantResponse> {
        val query = GetProductVariantsQuery().build(productId)
        return webClient.postQuery(query)
    }
}