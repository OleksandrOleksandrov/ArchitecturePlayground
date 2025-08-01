package com.oleksandr.common.exception

/**
 * Represents an exception related to an API request.
 *
 * This class extends [AppException] and adds additional properties to capture the request URL and HTTP code
 * associated with the error. It is intended for use in situations where an API request fails or encounters issues.
 *
 * @param requestUrl The URL of the API request that caused the exception.
 * @param httpCode The HTTP status code returned by the API.
 * @param message The detail message for this exception, or `null` if none.
 * @param cause The cause of this exception, or `null` if none.
 */
open class ApiException(
    open val requestUrl: String? = null,
    open val httpCode: Int? = null,
    override val message: String? = null,
    override val cause: Throwable? = null,
) : AppException(message, cause)

/**
 * Represents an exception for unauthorized access, typically in the context of API requests.
 *
 * This class extends [ApiException] and is used to handle cases where the user is not authorized to access
 * a particular resource or perform an operation. It includes details such as the request URL, HTTP code,
 * and optional message and cause.
 *
 * @param requestUrl The URL of the API request that caused the exception.
 * @param httpCode The HTTP status code returned by the API (typically 401 for unauthorized).
 * @param message The detail message for this exception, or `null` if none.
 * @param cause The cause of this exception, or `null` if none.
 */
data class NotAuthorizedException(
    override val requestUrl: String,
    override val httpCode: Int,
    override val message: String? = null,
    override val cause: Throwable? = null,
): ApiException(requestUrl, httpCode, message, cause)
