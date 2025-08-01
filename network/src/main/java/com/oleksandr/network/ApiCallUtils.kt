package com.oleksandr.network

import android.util.Log
import com.oleksandr.common.core.Resource
import com.oleksandr.common.exception.AppException
import com.oleksandr.common.exception.ConnectionApiException
import com.oleksandr.common.exception.UnknownApiException
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T> apiCall(
    //3xx
    onRedirect: suspend (HttpResponse) -> Resource<T> = { Resource.Failure(UnknownApiException()) },
    //4xx
    onBadRequest: suspend (HttpResponse) -> Resource<T> = { Resource.Failure(UnknownApiException()) },
    onClientRequestException: suspend (AppException) -> Resource<T> = { Resource.Failure(UnknownApiException()) },
    //5xx
    onServerException: suspend (HttpResponse) -> Resource<T> = { Resource.Failure(UnknownApiException()) },
    onConnectionError: suspend (Exception) -> Resource<T> = { Resource.Failure(
        ConnectionApiException(it)
    ) },
    onOther: suspend (Exception) -> Resource<T> = { Resource.Failure(UnknownApiException()) },
    call: suspend () -> T,
): Resource<T> {
    var error: Throwable? = null
    return try {
        //extra try/catch to catch errors from onRedirect/onBadRequest/onServerException in case of failed serialization
        try {
            Resource.Success(call())
        } catch (e: RedirectResponseException) {
            error = e
            onRedirect(e.response)
        } catch (e: ClientRequestException) {
            error = e
            onBadRequest(e.response)
        } catch (e: ServerResponseException) {
            error = e
            onServerException(e.response)
        }
    } catch (e: Exception) {
        error = e
        if (e.isConnectionError()) {
            onConnectionError(e)
        } else {
            onOther(e)
        }
    } finally {
        error?.let { Log.e(API_CALL_ERROR_TAG, "", it) }
    }
}

suspend fun <T, R> Resource<T>.mapApiCall(
    onRedirect: suspend (HttpResponse) -> Resource.Failure = { Resource.Failure(UnknownApiException()) },
    onBadRequest: suspend (HttpResponse) -> Resource.Failure = { Resource.Failure(UnknownApiException()) },
    onClientRequestException: suspend (AppException) -> Resource.Failure = { Resource.Failure(UnknownApiException()) },
    onServerException: suspend (HttpResponse) -> Resource.Failure = { Resource.Failure(UnknownApiException()) },
    onConnectionError: suspend (Exception) -> Resource.Failure = { Resource.Failure(ConnectionApiException(it)) },
    onOther: suspend (Exception) -> Resource.Failure = { Resource.Failure(UnknownApiException()) },
    call: suspend (T) -> R,
): Resource<R> {
    return this.map {
        apiCall(
            onRedirect, onBadRequest, onClientRequestException, onServerException, onConnectionError, onOther
        ) { call(it.data) }
    }
}

private const val API_CALL_ERROR_TAG = "API_ERROR"

private fun Throwable?.isConnectionError(): Boolean {
    return this is UnknownHostException ||
            this is SocketException ||
            this is SocketTimeoutException ||
            (this?.cause?.isConnectionError() ?: false)
}
