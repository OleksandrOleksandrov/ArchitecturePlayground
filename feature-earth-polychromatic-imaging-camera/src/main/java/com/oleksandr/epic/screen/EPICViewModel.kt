package com.oleksandr.epic.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oleksandr.common.extension.withListMapper
import com.oleksandr.epic.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.usecase.EPICDataListFlowUseCase
import com.oleksandr.epic.usecase.UpdateEPICUseCase
import kotlinx.coroutines.launch

class EPICViewModel(
    private val updateEPICUseCase: UpdateEPICUseCase,
    private val ePICDataListFlowUseCase: EPICDataListFlowUseCase,
    private val ePICUiDomainModelMapper: EPICDomainUiModelMapper,
) : ViewModel() {

    val epicList = ePICDataListFlowUseCase().withListMapper(ePICUiDomainModelMapper)

    init {
        viewModelScope.launch {
            updateEPICUseCase()
        }
    }
}