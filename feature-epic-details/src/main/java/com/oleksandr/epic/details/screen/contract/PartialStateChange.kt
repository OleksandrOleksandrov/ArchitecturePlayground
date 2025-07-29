package com.oleksandr.epic.details.screen.contract

import com.oleksandr.presentation.core.model.EpicUiModel

internal sealed interface PartialStateChange {
    fun reduce(state: ViewState): ViewState

    sealed interface EpicData : PartialStateChange {
        data class SetData(
            val item: EpicUiModel? = null,
        ) : EpicData

        override fun reduce(state: ViewState): ViewState = when (this) {
            is SetData -> state.copy(
                epicUiModel = item,
            )
        }
    }
}
