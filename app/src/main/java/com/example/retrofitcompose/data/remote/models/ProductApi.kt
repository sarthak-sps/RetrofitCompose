package com.example.retrofitcompose.data.remote.models

import retrofit2.Response
import retrofit2.http.GET

interface ProductApi
{
@GET("products")
suspend fun  getAllProducts(): Response<List<ProductItemItem>>
}