package com.oleksandr.apod.source

import io.ktor.client.statement.HttpResponse

interface APODNetSource {
    suspend fun fetchAPOD(): HttpResponse
}