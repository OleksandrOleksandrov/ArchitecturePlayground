package com.oleksandr.epic.screen.contract

import android.os.Bundle
import android.os.Parcelable
import androidx.compose.runtime.Immutable
import androidx.core.os.bundleOf
import com.oleksandr.presentation.core.model.EpicUiModel
import com.oleksandr.presentation.core.model.PictureOfDayUiModel
import com.oleksandr.presentation.core.platform.base.ext.parcelable
import com.oleksandr.presentation.core.platform.base.mvi.MviViewState
import com.oleksandr.presentation.core.platform.base.mvi.MviViewStateSaver
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
internal data class ViewState(
    val isProcessing: Boolean = true,
    val pictureUiState: PictureOfDayUiModel? = null,
    val epicList: List<EpicUiModel> = emptyList(),
    val isListLoadingError: Boolean = false,
) : MviViewState,
    Parcelable {
    companion object {
        private const val VIEW_STATE_KEY = "com.oleksandrov.cmp.arch.playground.epic.screen.contract.ViewState"
    }

    class StateSaver : MviViewStateSaver<ViewState> {
        override fun ViewState.toBundle(): Bundle = bundleOf(VIEW_STATE_KEY to this)

        override fun restore(bundle: Bundle?): ViewState = bundle
            ?.parcelable<ViewState>(VIEW_STATE_KEY)
            ?.copy(isProcessing = false)
            ?: ViewState()
    }
}
