package com.oleksandr.epic.source.impl

import com.oleksandr.epic.source.EPICNetSource
import com.oleksandr.network.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class EPICNetSourceImpl(
    private val client: HttpClient,
) : EPICNetSource {
    override suspend fun fetchEpic(): HttpResponse =
        client.get(HttpRoutes.EPIC_PICTURE_LIST).body()
}