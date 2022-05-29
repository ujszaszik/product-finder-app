package ch.galaxus.productfinder.features.products.details.accessories.domain

import ch.galaxus.productfinder.network.response.QueryResponse
import kotlinx.serialization.Serializable

@Serializable
data class ItemAccessoriesResponse(val data: AccessoriesData) : QueryResponse

fun ItemAccessoriesResponse.getAccessoriesIds(): List<Int> =
    data.productDetailsV3.productDetails.popularAccessoryProductIds

@Serializable
data class AccessoriesData(val productDetailsV3: ProductDetailsV3)

@Serializable
data class ProductDetailsV3(val productDetails: ProductDetails)

@Serializable
data class ProductDetails(val popularAccessoryProductIds: List<Int>)