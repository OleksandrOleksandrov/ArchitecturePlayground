package com.oleksandr.epic.screen

import com.oleksandr.apod.usecase.APODDataFlowUseCase
import com.oleksandr.apod.usecase.UpdateAPODUseCase
import com.oleksandr.common.extension.withMapper
import com.oleksandr.common.extension.withNullableListMapper
import com.oleksandr.epic.mapper.APODDomainUiModelMapper
import com.oleksandr.epic.mapper.EPICDomainUiModelMapper
import com.oleksandr.epic.usecase.EPICDataListFlowUseCase
import com.oleksandr.epic.usecase.UpdateEPICUseCase
import com.oleksandr.presentation.core.platform.base.viewmodel.BaseViewModel

class EPICViewModel(
    private val updateEPICUseCase: UpdateEPICUseCase,
    ePICDataListFlowUseCase: EPICDataListFlowUseCase,
    private val updateAPODUseCase: UpdateAPODUseCase,
    aPODDataFlowUseCase: APODDataFlowUseCase,
) : BaseViewModel() {

    val epicList = ePICDataListFlowUseCase().withNullableListMapper(EPICDomainUiModelMapper)
    val apod = aPODDataFlowUseCase().withMapper(APODDomainUiModelMapper)

    init {
        launch {
            updateAPODUseCase()
            updateEPICUseCase()
        }
    }
}