package com.example.retrofitcompose.data.remote.models

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductService @Inject constructor(private val productApi:ProductApi){

    suspend fun getProducts():List<ProductItemItem>
    {
                return withContext(Dispatchers.IO){
                      val product= productApi.getAllProducts()
                    product.body()?: emptyList()
                }
    }
}