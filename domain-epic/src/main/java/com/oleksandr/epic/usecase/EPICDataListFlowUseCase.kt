package com.oleksandr.epic.usecase

import com.oleksandr.epic.model.EPICDomainModel
import kotlinx.coroutines.flow.Flow

interface EPICDataListFlowUseCase {
    operator fun invoke(): Flow<List<EPICDomainModel>>
}