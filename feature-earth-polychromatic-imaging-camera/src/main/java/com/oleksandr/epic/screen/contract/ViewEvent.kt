package com.oleksandr.epic.screen.contract

import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.core.platform.base.mvi.MviSingleEvent

internal sealed interface ViewEvent : MviSingleEvent {

    /**
     * Represents the event that the data has not been loaded successfully.
     */
    data class ShowError(
        val message: String?,
    ) : ViewEvent

    /**
     * Represents the event that navigates to details.
     */
    data class NavigateToEpicDetails(
        val model: EpicUiModel,
    ) : ViewEvent
}
