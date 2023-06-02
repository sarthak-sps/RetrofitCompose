package com.example.retrofitcompose.domain.items

import com.example.retrofitcompose.data.remote.models.ProductItemItem

data class ProductItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String
)

fun ProductItemItem.toProductItem()= ProductItem(category,description,id,image,price,title)