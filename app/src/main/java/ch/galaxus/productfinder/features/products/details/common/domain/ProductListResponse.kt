package ch.galaxus.productfinder.features.products.details.common.domain

import ch.galaxus.productfinder.features.products.details.info.domain.DGResult
import ch.galaxus.productfinder.network.response.QueryResponse
import kotlinx.serialization.Serializable

@Serializable
data class ProductListResponse(val data: ProductListData) : QueryResponse

@Serializable
data class ProductListData(val productsWithOfferDefault: ProductsWithOfferDefault)

@Serializable
data class ProductsWithOfferDefault(val products: List<DGResult>)