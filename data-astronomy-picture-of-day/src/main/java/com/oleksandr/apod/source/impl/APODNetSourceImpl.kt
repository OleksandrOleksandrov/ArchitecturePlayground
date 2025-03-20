package com.oleksandr.apod.source.impl

import com.oleksandr.apod.source.APODNetSource
import com.oleksandr.network.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

internal class APODNetSourceImpl(
    private val client: HttpClient,
) : APODNetSource {
    override suspend fun fetchAPOD(): HttpResponse = client.get(HttpRoutes.APOD).body()
}