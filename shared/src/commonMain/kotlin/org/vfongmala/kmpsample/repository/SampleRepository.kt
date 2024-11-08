package org.vfongmala.kmpsample.repository

import org.vfongmala.kmpsample.data.SampleResponse
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface SampleRepository {
    suspend fun getSample(): SampleResponse
}

class SampleRepositoryImpl : SampleRepository {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
                isLenient = true
                coerceInputValues = true
                ignoreUnknownKeys = true
            })
        }
        defaultRequest {
            host = "192.168.1.109"
            port = 8080
        }
    }
    override suspend fun getSample(): SampleResponse {
        return client.get("/").body()
    }
}