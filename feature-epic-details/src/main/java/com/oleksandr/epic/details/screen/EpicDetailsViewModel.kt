package com.oleksandr.epic.details.screen

import com.oleksandr.epic.details.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.usecase.EPICDataListFlowUseCase
import com.oleksandr.epic.usecase.UpdateEPICUseCase
import com.oleksandr.presentation.core.platform.base.viewmodel.BaseViewModel

class EpicDetailsViewModel(
    private val updateEPICUseCase: UpdateEPICUseCase,
    ePICDataListFlowUseCase: EPICDataListFlowUseCase,
    ePICUiDomainModelMapper: EPICDomainUiModelMapper,
) : BaseViewModel() {

}