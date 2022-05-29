package ch.galaxus.productfinder.features.products.details.info.domain

import ch.galaxus.productfinder.network.response.QueryResponse
import kotlinx.serialization.Serializable

@Serializable
data class ProductDetailsResponse(val data: SearchData) : QueryResponse

@Serializable
data class SearchData(val search: Search)

@Serializable
data class Search(val products: Products)

@Serializable
data class Products(val total: Int, val hasMore: Boolean, val results: List<DGResult>)

@Serializable
data class DGResult(val product: Product, val offer: Offer)

@Serializable
data class Product(
    val productId: Int,
    val brandName: String,
    val name: String,
    val nameProperties: String?,
    val images: List<Image>
)

@Serializable
data class Image(val url: String)

@Serializable
data class Offer(val price: Price)

@Serializable
data class Price(val amountIncl: Double, val currency: String)