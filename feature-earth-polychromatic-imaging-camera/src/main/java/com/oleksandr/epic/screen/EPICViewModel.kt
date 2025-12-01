package com.oleksandr.epic.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.oleksandr.apod.usecase.APODDataFlowUseCase
import com.oleksandr.apod.usecase.UpdateAPODUseCase
import com.oleksandr.epic.mapper.APODDomainUiModelMapper
import com.oleksandr.epic.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.screen.contract.PartialStateChange
import com.oleksandr.epic.screen.contract.ViewEvent
import com.oleksandr.epic.screen.contract.ViewIntent
import com.oleksandr.epic.screen.contract.ViewState
import com.oleksandr.epic.usecase.EPICDataListUseCase
import com.oleksandr.presentation.core.platform.base.ext.stateWhileSubscribed
import com.oleksandr.presentation.core.platform.base.viewmodel.BaseMviViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.transformLatest

internal class EPICViewModel(
    private val ePICDataListUseCase: EPICDataListUseCase,
    private val aPODDataFlowUseCase: APODDataFlowUseCase,
    private val updateAPODUseCase: UpdateAPODUseCase,
    savedStateHandle: SavedStateHandle,
    stateSaver: ViewState.StateSaver,
) : BaseMviViewModel<ViewIntent, ViewState, ViewEvent>() {
    override val viewState: StateFlow<ViewState>

    init {
        val initialState = stateSaver.restore(savedStateHandle[VIEW_STATE_BUNDLE_KEY])

        viewState = intentFlow
            .onStart {
                emit(ViewIntent.OnStartIntent)

            }.toPartialStateChange()
            .onEach {
                it.toSingleEventOrNull()?.also { sendEvent(it) }
            }.scan(initialState) { state, change -> change.reduce(state) }
            .stateWhileSubscribed(viewModelScope, initialState)

        savedStateHandle.setSavedStateProvider(VIEW_STATE_BUNDLE_KEY) {
            stateSaver.run { viewState.value.toBundle() }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun Flow<ViewIntent>.toPartialStateChange(): Flow<PartialStateChange> {
        val loadInfoFlow = filterIsInstance<ViewIntent.OnStartIntent>()
            .transformLatest { _ ->
                ePICDataListUseCase().onSuccess { list ->
                    launch(
                        onError = {
                           // TODO Handle error.
                        }
                    ) {
                        updateAPODUseCase()
                    }
                    emit(PartialStateChange.EpicList.SetData(list?.map {
                        EPICDomainUiModelMapper.mapTo(it)
                    } ?: emptyList()))
                }.onFailure {
                    emit(PartialStateChange.EpicList.SetData(emptyList()))
                }
                aPODDataFlowUseCase().collectLatest { pictureOfDayDomainModel ->
                    pictureOfDayDomainModel?.let {
                        emit(
                            PartialStateChange.PictureOfDay.SetData(
                                APODDomainUiModelMapper.mapTo(
                                    pictureOfDayDomainModel
                                )
                            )
                        )
                    }
                }
                launch(
                    onError = {
                        // TODO Handle error.
                    }
                ) {
                    updateAPODUseCase()
                }
            }

        val onEpicTappedFlow = filterIsInstance<ViewIntent.OnEpicItemTappedIntent>().mapLatest {
            PartialStateChange.Navigation.NavigateToDetails(it.model)
        }

        return merge(
            loadInfoFlow,
            onEpicTappedFlow,
        )
    }

    companion object {
        private const val VIEW_STATE_BUNDLE_KEY = "com.oleksandr.epic.screen.contract.view_state"

        private fun PartialStateChange.toSingleEventOrNull(): ViewEvent? = when (this) {
            is PartialStateChange.Navigation -> {
                with(this) {
                    when (this) {
                        is PartialStateChange.Navigation.NavigateToDetails -> ViewEvent.NavigateToEpicDetails(model)
                    }
                }
            }
            else -> null
        }
    }
}