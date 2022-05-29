package ch.galaxus.productfinder.features.products.details.info.mapper

import ch.galaxus.productfinder.features.products.details.info.domain.Offer
import ch.galaxus.productfinder.features.products.details.info.model.ProductPrice

object ProductPriceMapper {

    fun map(offer: Offer): ProductPrice {
        return ProductPrice(offer.price.amountIncl, offer.price.currency)
    }
}