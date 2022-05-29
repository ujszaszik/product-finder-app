package ch.galaxus.productfinder.features.products.details.variants.domain

import ch.galaxus.productfinder.network.query.NetworkQuery

/**
 * Query to load a list of variants and their product Id for a given product
 */
class GetProductVariantsQuery : NetworkQuery<Int> {

    override val value: String
        get() = """
        {
            productDetailsV3(productId: {$parameter}) {
                productDetails {
                    variants {
                        variantId
                        name
                        type
                        products {
                            productId
                            label
                            imageUrl
                        }
                    }
                }
            }
        }
        """.trimIndent()

    override val parameter = "productId"

    override fun acceptParam(param: Int) = param.toString()
}