package com.example.testapp.repository.product

import com.example.testapp.api.Http
import com.example.testapp.dto.products.ProductsList
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ProductRepoInterface {
    suspend fun getProducts() : Result<ProductsList>
}

class ProductRepository : ProductRepoInterface {

    override suspend fun getProducts(): Result<ProductsList> = withContext(Dispatchers.IO){
        try {
            val response : HttpResponse = Http.api.get("/products?limit=10&skip=10")
            val body : ProductsList = response.body<ProductsList>()
            Result.success(body)
        }
        catch (e: CancellationException) {
            throw e // Let Kotlin cancel the coroutine cleanly
        }
        catch (e : Exception){
            Result.failure(e) // Only real network/JSON errors become Result.failure
        }
    }
}