package com.oleksandr.epic.usecase.impl

import com.oleksandr.common.domain.resultLauncher
import com.oleksandr.epic.mapper.EPICDomainRepoModelMapper
import com.oleksandr.epic.model.EPICDomainModel
import com.oleksandr.epic.repository.EPICRepository
import com.oleksandr.epic.usecase.GetEPICItemByIdUseCase

internal class GetEPICItemByIdUseCaseImpl(
    private val repository: EPICRepository,
) : GetEPICItemByIdUseCase {
    override suspend fun invoke(id: String): Result<EPICDomainModel?> = resultLauncher {
        repository.getEpicById(id)?.let(EPICDomainRepoModelMapper::mapFrom)
    }
}
