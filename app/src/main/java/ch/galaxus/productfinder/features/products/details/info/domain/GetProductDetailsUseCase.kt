package ch.galaxus.productfinder.features.products.details.info.domain

import ch.galaxus.productfinder.coroutines.mapResource
import ch.galaxus.productfinder.features.products.details.common.repository.IProductRepository
import ch.galaxus.productfinder.features.products.details.info.mapper.ProductDetailsMapper
import ch.galaxus.productfinder.features.products.details.info.model.ProductDetailsModel
import ch.galaxus.productfinder.network.ResourceFlow
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(private val repository: IProductRepository) {

    operator fun invoke(eanCode: String): ResourceFlow<ProductDetailsModel> {
        return repository
            .getDetails(eanCode)
            .mapResource { ProductDetailsMapper.map(it) }
    }
}