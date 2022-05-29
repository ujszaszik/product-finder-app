package ch.galaxus.productfinder.features.products.details.accessories.domain

import ch.galaxus.productfinder.coroutines.chainResource
import ch.galaxus.productfinder.coroutines.mapResource
import ch.galaxus.productfinder.features.products.details.accessories.mapper.ProductAccessoriesMapper
import ch.galaxus.productfinder.features.products.details.accessories.model.ProductAccessoriesModel
import ch.galaxus.productfinder.features.products.details.common.repository.IProductRepository
import ch.galaxus.productfinder.network.ResourceFlow
import javax.inject.Inject

class GetPopularAccessoriesUseCase @Inject constructor(
    private val repository: IProductRepository
) {

    operator fun invoke(productId: Int): ResourceFlow<ProductAccessoriesModel> {
        return repository
            .getAccessories(productId)
            .chainResource(
                mapper = { it.getAccessoriesIds() },
                trigger = { repository.getProductsList(it) }
            ).mapResource { ProductAccessoriesMapper.map(it) }
    }

}