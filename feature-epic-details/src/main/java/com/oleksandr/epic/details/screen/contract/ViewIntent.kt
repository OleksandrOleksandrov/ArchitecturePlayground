package com.oleksandr.epic.details.screen.contract

import com.oleksandr.presentation.core.platform.base.mvi.MviIntent

internal sealed interface ViewIntent : MviIntent {

    /**
     * Represents the initial intent to load the data when init.
     */
    data class OnStartIntent(val id: String) : ViewIntent
}
