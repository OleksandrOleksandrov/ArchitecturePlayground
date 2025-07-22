package com.oleksandr.presentation.core.platform.base.viewmodel

import com.oleksandr.presentation.core.platform.base.mvi.MviIntent
import com.oleksandr.presentation.core.platform.base.mvi.MviSingleEvent
import com.oleksandr.presentation.core.platform.base.mvi.MviViewModel
import com.oleksandr.presentation.core.platform.base.mvi.MviViewState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.onFailure
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.receiveAsFlow

abstract class BaseMviViewModel<I : MviIntent, S : MviViewState, E : MviSingleEvent> : MviViewModel<I, S, E>() {
    private val eventChannel = Channel<E>(Channel.UNLIMITED)
    private val intentMutableFlow = MutableSharedFlow<I>()

    final override val singleEvent: Flow<E> = eventChannel.receiveAsFlow()

    final override suspend fun processIntent(intent: I) {
        intentMutableFlow.emit(intent)
    }

    override fun onCleared() {
        super.onCleared()
        eventChannel.close()
    }

    /**
     * Must be called in [kotlinx.coroutines.Dispatchers.Main.immediate],
     * otherwise it will throw an exception.
     *
     * If you want to send an event from other [kotlinx.coroutines.CoroutineDispatcher],
     * use `withContext(Dispatchers.Main.immediate) { sendEvent(event) }`.
     */
    protected suspend fun sendEvent(event: E) {
        eventChannel
            .trySend(event)
            .onFailure {
                // TODO: logging error "Failed to send event: $event"
            }
    }

    protected val intentFlow: SharedFlow<I> get() = intentMutableFlow
}
