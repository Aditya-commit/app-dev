package com.example.testapp.dto.products

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id : Int ,
    val title : String,
    val description : String,
    val category : String,
    val price : Double,
    val discountPercentage : Double,
    val rating : Double,
    val brand : String? = null,
    val thumbnail : String,
)