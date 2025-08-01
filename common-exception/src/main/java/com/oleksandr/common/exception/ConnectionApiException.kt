package com.oleksandr.common.exception

/**
 * A custom exception class representing connectivity-related errors.
 *
 * This exception is thrown when a network connection issue occurs, such as
 * a failure to connect to the server or a network timeout. It extends
 * [ApiException] and primarily focuses on capturing the original exception
 * that caused the connection failure.
 *
 * @property originException The original exception that triggered this connection error.
 */
class ConnectionApiException(
    val originException: Exception,
) : ApiException(cause = originException) {

    /**
     * Returns a string representation of the [ConnectionApiException] instance,
     * including details about the original exception that caused the connection error.
     */
    override fun toString(): String = "ConnectionApiException(originException=${
        originException::class.simpleName + ": " + originException.message
    })"
}
