package com.example.testapp.dto.carts

import kotlinx.serialization.Serializable

@Serializable
data class CartResponse(
    val carts : List<Cart>
)