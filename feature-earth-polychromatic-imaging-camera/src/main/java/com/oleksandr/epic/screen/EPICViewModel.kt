package com.oleksandr.epic.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oleksandr.apod.usecase.APODDataFlowUseCase
import com.oleksandr.apod.usecase.UpdateAPODUseCase
import com.oleksandr.common.extension.withMapper
import com.oleksandr.common.extension.withNullableListMapper
import com.oleksandr.epic.mapper.APODDomainUiModelMapper
import com.oleksandr.epic.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.usecase.EPICDataListFlowUseCase
import com.oleksandr.epic.usecase.UpdateEPICUseCase
import kotlinx.coroutines.launch

class EPICViewModel(
    private val updateEPICUseCase: UpdateEPICUseCase,
    ePICDataListFlowUseCase: EPICDataListFlowUseCase,
    private val updateAPODUseCase: UpdateAPODUseCase,
    aPODDataFlowUseCase: APODDataFlowUseCase,
) : ViewModel() {

    val epicList = ePICDataListFlowUseCase().withNullableListMapper(EPICDomainUiModelMapper)
    val apod = aPODDataFlowUseCase().withMapper(APODDomainUiModelMapper)

    init {
        viewModelScope.launch {
            updateAPODUseCase()
            updateEPICUseCase()
        }
    }
}