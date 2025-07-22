package com.oleksandr.epic.usecase

import com.oleksandr.epic.model.EPICDomainModel

interface EPICDataListUseCase {
    suspend operator fun invoke(): Result<List<EPICDomainModel>?>
}