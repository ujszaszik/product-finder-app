package ch.galaxus.productfinder.features.products.details.variants.domain

import ch.galaxus.productfinder.coroutines.mapResource
import ch.galaxus.productfinder.features.products.details.common.repository.IProductRepository
import ch.galaxus.productfinder.features.products.details.variants.mapper.ProductVariantsMapper
import ch.galaxus.productfinder.features.products.details.variants.model.ProductVariantsModel
import ch.galaxus.productfinder.network.ResourceFlow
import javax.inject.Inject

class GetProductVariantsUseCase @Inject constructor(private val repository: IProductRepository) {

    operator fun invoke(productId: Int): ResourceFlow<ProductVariantsModel> {
        return repository
            .getVariants(productId)
            .mapResource { ProductVariantsMapper.map(it) }
    }
}