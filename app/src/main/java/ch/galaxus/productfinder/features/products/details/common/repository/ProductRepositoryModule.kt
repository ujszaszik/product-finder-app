package ch.galaxus.productfinder.features.products.details.common.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ProductRepositoryModule {

    @Binds
    @Singleton
    fun bindProductRepository(productRepository: ProductRepository): IProductRepository
}