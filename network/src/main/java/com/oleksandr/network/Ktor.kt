package com.oleksandr.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val TIME_OUT = 15_000L
private const val LOG_TAG = "KTOR_LOG"

internal fun client() = HttpClient(Android) {

    expectSuccess = true

    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }
        )
    }

    install(HttpTimeout) {
        connectTimeoutMillis = TIME_OUT
        requestTimeoutMillis = TIME_OUT
        socketTimeoutMillis = TIME_OUT
    }

    install(Logging) {
        logger = KtorLogger
        level = LogLevel.BODY
    }

    install(DefaultRequest) {
        headers.append("Content-Type", "application/json")
        headers.append("platform", "android")
    }

}

private object KtorLogger : Logger {
    override fun log(message: String) {
        Log.i(LOG_TAG, message)
    }
}
