package ch.galaxus.productfinder.network.request

import kotlinx.serialization.Serializable

@Serializable
data class QueryRequest(
    val query: String
)