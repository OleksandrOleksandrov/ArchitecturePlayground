package com.oleksandr.common.exception

/**
 * An exception class representing an unknown error that occurs during an API call.
 * Any error which is not mentioned before !(400, 404, 422, 5XX)
 *
 * @param originException The original exception that caused this unknown error, if available.
 *
 * @see ApiException
 */
class UnknownApiException(
    val originException: Exception? = null,
) : ApiException(cause = originException) {
    override fun toString(): String = "ApiException(originException=${
        originException?.let {
            it::class.simpleName + ": " + it.message
        } ?: "N/A"
    })"
}
