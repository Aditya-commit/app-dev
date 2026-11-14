package com.example.testapp.dto.carts

import com.example.testapp.dto.products.Product
import kotlinx.serialization.Serializable

@Serializable
data class Cart(
    val id : Int,
    val products : List<Product>
)