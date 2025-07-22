package com.oleksandr.epic.screen.contract

import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.core.model.PictureOfDayUiModel

internal sealed interface PartialStateChange {
    fun reduce(state: ViewState): ViewState

    sealed interface EpicList : PartialStateChange {
        data class SetData(
            val list: List<EpicUiModel>,
        ) : EpicList

        data object SetError: EpicList

        override fun reduce(state: ViewState): ViewState = when (this) {
            is SetData -> state.copy(
                isProcessing = false,
                epicList = list,
            )

            SetError -> state.copy(
                isProcessing = false,
                isListLoadingError = true,
            )
        }
    }

    sealed interface PictureOfDay : PartialStateChange {
        data class SetData(
            val pictureOfDay: PictureOfDayUiModel?,
        ) : PictureOfDay

        override fun reduce(state: ViewState): ViewState = when(this) {
            is SetData -> state.copy(pictureUiState = pictureOfDay)
        }
    }

    sealed interface Navigation : PartialStateChange {
        override fun reduce(state: ViewState): ViewState = state

        data class NavigateToDetails(
            val model: EpicUiModel,
        ) : Navigation
    }
}
