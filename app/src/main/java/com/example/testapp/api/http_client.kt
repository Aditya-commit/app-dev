package com.example.testapp.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object Http {
    val api = HttpClient(Android) {
        followRedirects = true
        engine {
            connectTimeout = 3000
        }
        defaultRequest {
            url("https://dummyjson.com")
        }
        install(HttpRequestRetry){
            maxRetries = 2
            retryOnServerErrors(maxRetries = 5)
            exponentialDelay(
                base = 2.0, // DELAY MULTIPLIER
                baseDelayMs = 1000, // INITIAL DELAY
                maxDelayMs = 5000, // STOP MULTIPLYING THE DELAY WITH base AFTER REACHING TO maxDelayMs
                2000
            )
        }
        install(HttpTimeout){
            requestTimeoutMillis = 3000
            connectTimeoutMillis = 1000
            socketTimeoutMillis = 1000
        }
        install(ContentNegotiation){
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }
}