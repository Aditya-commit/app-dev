package com.example.testapp.dto.products

import kotlinx.serialization.Serializable

@Serializable
data class ProductsList(
    val products : List<Product>
)
