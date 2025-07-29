package com.oleksandr.epic.usecase

import com.oleksandr.epic.model.EPICDomainModel

interface GetEPICItemByIdUseCase {
    suspend operator fun invoke(id: String): Result<EPICDomainModel?>
}