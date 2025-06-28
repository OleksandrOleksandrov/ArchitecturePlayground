package com.oleksandr.presentation.core.platform.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BaseViewModel : ViewModel() {

    /**
     * Launches a coroutine with optional loading, result, and error handling.
     *
     * This function launches a coroutine in the specified [coroutineScope] with the given [coroutineContext].
     * It provides hooks for loading, result, and error handling, and supports an optional debounce period.
     * The function is protected and intended to be used within a class or its subclasses.
     *
     * Usage:
     *
     * ```kotlin
     * launch(
     *     coroutineContext = Dispatchers.IO,
     *     coroutineScope = viewModelScope,
     *     request = { fetchData() },
     *     onLoading = { isLoading -> showLoadingIndicator(isLoading) },
     *     onResult = { result -> handleResult(result) },
     *     onError = { error -> showError(error) },
     * )
     * ```
     *
     * @param T The type of the result returned by the [request] function.
     * @param coroutineContext The context in which the coroutine will be executed. Defaults to [Dispatchers.IO].
     * @param coroutineScope The scope in which the coroutine will be launched. Defaults to [viewModelScope].
     * @param request The suspend function to be executed within the coroutine.
     * @param onLoading A callback to be invoked with the loading state. Can be null.
     * @param onResult A callback to be invoked with the result of the [request] function. Can be null.
     * @param onError A callback to be invoked with any errors that occur during the execution. Can be null.
     * @return The [Job] representing the coroutine.
     */
    protected fun <T> launch(
        coroutineContext: CoroutineDispatcher = Dispatchers.IO,
        coroutineScope: CoroutineScope = viewModelScope,
        onLoading: (suspend (Boolean) -> Unit)? = null,
        onResult: (suspend (T?) -> Unit)? = null,
        // TODO: maybe, change to UiError whatever
        onError: (suspend (Throwable) -> Unit)? = null,
        request: suspend CoroutineScope.() -> T?,
    ): Job {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
//            loggerPublisher.log(throwable)
            coroutineScope.launch {
                // TODO: maybe, change to UiError whatever
//                val uiError = handleException(throwable)
//                uiError?.let { onError?.invoke(it) }
                onError?.invoke(throwable)
                onLoading?.invoke(false)
            }
        }
        return coroutineScope.launch(
            context = exceptionHandler + coroutineContext,
        ) {
            onLoading?.invoke(true)
            withContext(coroutineContext) { request() }.apply {
                this.let { result ->
                    onResult?.invoke(result)
                    onLoading?.invoke(false)
                }
            }
        }
    }
}