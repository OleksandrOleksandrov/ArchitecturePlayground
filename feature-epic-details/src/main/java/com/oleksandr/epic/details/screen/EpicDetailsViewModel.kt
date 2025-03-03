package com.oleksandr.epic.details.screen

import androidx.lifecycle.ViewModel
import com.oleksandr.epic.details.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.usecase.EPICDataListFlowUseCase
import com.oleksandr.epic.usecase.UpdateEPICUseCase

class EpicDetailsViewModel(
    private val updateEPICUseCase: UpdateEPICUseCase,
    ePICDataListFlowUseCase: EPICDataListFlowUseCase,
    ePICUiDomainModelMapper: EPICDomainUiModelMapper,
) : ViewModel() {

}