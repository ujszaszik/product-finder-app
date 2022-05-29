package ch.galaxus.productfinder.features.products.details.accessories.domain

import ch.galaxus.productfinder.network.query.NetworkQuery

class GetPopularAccessoriesQuery : NetworkQuery<Int> {

    override val value: String
        get() = """
        {
            productDetailsV3(productId: {$parameter}) {
                productDetails {
                    popularAccessoryProductIds
                }
            }
        }
        """.trimIndent()

    override val parameter = "productId"

    override fun acceptParam(param: Int) = param.toString()
}