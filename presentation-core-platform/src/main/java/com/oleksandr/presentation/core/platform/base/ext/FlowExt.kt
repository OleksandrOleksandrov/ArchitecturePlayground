package com.oleksandr.presentation.core.platform.base.ext

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.stateIn

/**
 * State the flow lazily.
 */
fun <T> Flow<T>.stateLazily(
    scope: CoroutineScope,
    initialState: T,
): StateFlow<T> =
    stateIn(
        scope = scope,
        started = SharingStarted.Lazily,
        initialValue = initialState,
    )

/**
 * Share the flow lazily.
 */
fun <T> Flow<T>.shareLazily(
    scope: CoroutineScope,
): SharedFlow<T> =
    shareIn(
        scope = scope,
        started = SharingStarted.Lazily,
    )

/**
 * Share the flow while subscribed.
 */
fun <T> Flow<T>.stateWhileSubscribed(
    scope: CoroutineScope,
    initialState: T,
    stopTimeoutMillis: Long = DEFAULT_STOP_TIMEOUT_MILLIS,
): StateFlow<T> =
    stateIn(
        scope = scope,
        started = SharingStarted.WhileSubscribed(
            stopTimeoutMillis = stopTimeoutMillis,
        ),
        initialValue = initialState,
    )

/**
 * Share the flow,
 * start when the first subscriber arrives,
 * and stop when the last subscriber leaves.
 */
fun <T> Flow<T>.shareWhileSubscribed(
    scope: CoroutineScope,
    stopTimeoutMillis: Long = DEFAULT_STOP_TIMEOUT_MILLIS,
): SharedFlow<T> =
    shareIn(
        scope = scope,
        started = SharingStarted.WhileSubscribed(
            stopTimeoutMillis = stopTimeoutMillis,
        ),
    )

/**
 * [Why 5 seconds?](https://medium.com/androiddevelopers/things-to-know-about-flows-sharein-and-statein-operators-20e6ccb2bc74#a00b)
 */
private const val DEFAULT_STOP_TIMEOUT_MILLIS = 5_000L
