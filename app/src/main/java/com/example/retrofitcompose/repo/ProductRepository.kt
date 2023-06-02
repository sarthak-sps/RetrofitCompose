package com.example.retrofitcompose.repo

import com.example.retrofitcompose.data.remote.models.ProductItemItem
import com.example.retrofitcompose.data.remote.models.ProductService
import com.example.retrofitcompose.domain.items.ProductItem
import com.example.retrofitcompose.domain.items.toProductItem
import javax.inject.Inject

class ProductRepository @Inject constructor(private val productService: ProductService) {

    suspend fun getProduct(): List<ProductItem> {
        return productService.getProducts().map {
            it.toProductItem()
        }
    }
}