package ch.galaxus.productfinder.features.products.details.common.domain

import ch.galaxus.productfinder.network.query.NetworkQuery

class ProductListQuery : NetworkQuery<List<Int>> {

    override val value: String
        get() = """
       {
            productsWithOfferDefault(productIds: [{$parameter}]) {
                products {
                    product {
                        productId
                        brandName
                        name
                        nameProperties
                        images {
                            url
                        }
                    }
                    offer {
                        price {
                            amountIncl
                            currency
                        }
                        deliveryOptions {
                            mail {
                                classification
                            }
                        }
                    }
                }
            }
        }
        """.trimIndent()

    override val parameter = "productIds"

    override fun acceptParam(param: List<Int>) = param.joinToString(",")
}