package com.oleksandr.epic.details.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.oleksandr.epic.details.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.details.navigation.EpicDetailsDirections
import com.oleksandr.epic.details.screen.contract.PartialStateChange
import com.oleksandr.epic.details.screen.contract.ViewEvent
import com.oleksandr.epic.details.screen.contract.ViewIntent
import com.oleksandr.epic.details.screen.contract.ViewState
import com.oleksandr.epic.usecase.GetEPICItemByIdUseCase
import com.oleksandr.presentation.core.platform.base.ext.stateWhileSubscribed
import com.oleksandr.presentation.core.platform.base.viewmodel.BaseMviViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.transformLatest

internal class EpicDetailsViewModel(
    private val getEPICItemByIdUseCase: GetEPICItemByIdUseCase,
    savedStateHandle: SavedStateHandle,
    stateSaver: ViewState.StateSaver,
) : BaseMviViewModel<ViewIntent, ViewState, ViewEvent>() {
    private val route: EpicDetailsDirections.EpicDetails = savedStateHandle.toRoute()
    override val viewState: StateFlow<ViewState>

    init {
        val initialState = stateSaver.restore(savedStateHandle[VIEW_STATE_BUNDLE_KEY])

        viewState = intentFlow
            .onStart {
                emit(ViewIntent.OnStartIntent)
            }.toPartialStateChange()
            .onEach {
                it.toSingleEventOrNull()?.also { event -> sendEvent(event) }
            }.scan(initialState) { state, change -> change.reduce(state) }
            .stateWhileSubscribed(viewModelScope, initialState)

        savedStateHandle.setSavedStateProvider(VIEW_STATE_BUNDLE_KEY) {
            stateSaver.run { viewState.value.toBundle() }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun Flow<ViewIntent>.toPartialStateChange(): Flow<PartialStateChange> {
        val onStartFlow = filterIsInstance<ViewIntent.OnStartIntent>()
            .transformLatest { _ ->
                route.identifier?.let { id ->
                    getEPICItemByIdUseCase(id).onSuccess { item ->
                        emit(PartialStateChange.EpicData.SetData(item?.let {
                            EPICDomainUiModelMapper.mapTo(
                                it
                            )
                        }))
                    }
                }
            }

        return merge(
            onStartFlow,
        )
    }

    companion object {
        private const val VIEW_STATE_BUNDLE_KEY =
            "com.oleksandr.epic.details.screen.contract.view_state"

        private fun PartialStateChange.toSingleEventOrNull(): ViewEvent? = null
    }
}