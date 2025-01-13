package com.oleksandr.epic.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oleksandr.common.extension.withNullableListMapper
import com.oleksandr.epic.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.usecase.EPICDataListFlowUseCase
import com.oleksandr.epic.usecase.UpdateEPICUseCase
import kotlinx.coroutines.launch

class EPICViewModel(
    private val updateEPICUseCase: UpdateEPICUseCase,
    ePICDataListFlowUseCase: EPICDataListFlowUseCase,
    ePICUiDomainModelMapper: EPICDomainUiModelMapper,
) : ViewModel() {

    val epicList = ePICDataListFlowUseCase().withNullableListMapper(ePICUiDomainModelMapper)

    init {
        viewModelScope.launch {
            updateEPICUseCase()
        }
    }
}