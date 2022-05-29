package ch.galaxus.productfinder.features.products.details.info.domain

import ch.galaxus.productfinder.network.query.NetworkQuery

class GetProductDetailsQuery : NetworkQuery<String> {

    override val value: String
        get() = """
        {
            search(query: "{eanCode}") {
                products {
                    total
                    hasMore
                    results {
                        product {
                          productId
                          brandName
                          name
                          nameProperties
                          images { url }
                        }
                        offer {
                            price {
                                amountIncl
                                currency
                            }
                        }
                    }
                }
            }
        }
        """.trimIndent()

    override val parameter = "eanCode"

    override fun acceptParam(param: String) = param
}