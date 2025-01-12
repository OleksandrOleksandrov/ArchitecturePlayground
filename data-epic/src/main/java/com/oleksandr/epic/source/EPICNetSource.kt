package com.oleksandr.epic.source

import io.ktor.client.statement.HttpResponse

interface EPICNetSource {
    suspend fun fetchEpic(): HttpResponse
}