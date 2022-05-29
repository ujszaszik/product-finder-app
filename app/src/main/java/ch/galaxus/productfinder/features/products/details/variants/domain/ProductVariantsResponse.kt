package ch.galaxus.productfinder.features.products.details.variants.domain

import ch.galaxus.productfinder.network.response.QueryResponse
import kotlinx.serialization.Serializable

@Serializable
data class ProductVariantResponse(val data: ProductVariantData) : QueryResponse

@Serializable
data class ProductVariantData(val productDetailsV3: ProductVariantDetailsV3)

@Serializable
data class ProductVariantDetailsV3(val productDetails: ProductVariantDetails)

@Serializable
data class ProductVariantDetails(val variants: List<ProductVariants>)

@Serializable
data class ProductVariants(
    val variantId: Int,
    val name: String,
    val type: String,
    val products: List<ProductVariant>
)

@Serializable
data class ProductVariant(
    val productId: Int,
    val label: String,
    val imageUrl: String
)