package com.example.retrofitcompose.domain.items

import com.example.retrofitcompose.data.remote.models.ProductItemItem
import com.example.retrofitcompose.repo.ProductRepository
import javax.inject.Inject

class GetProductUseCase @Inject constructor(private val  productRepository: ProductRepository) {

suspend operator fun invoke():List<ProductItem>
{
    return productRepository.getProduct().shuffled()
}
}