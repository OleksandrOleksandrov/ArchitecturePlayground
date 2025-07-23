package com.oleksandr.epic.usecase.impl

import com.oleksandr.common.domain.resultLauncher
import com.oleksandr.epic.mapper.EPICDomainRepoModelMapper
import com.oleksandr.epic.model.EPICDomainModel
import com.oleksandr.epic.repository.EPICRepository
import com.oleksandr.epic.usecase.EPICDataListUseCase

class EPICDataListUseCaseImpl(
    private val repository: EPICRepository,
) : EPICDataListUseCase {
    override suspend operator fun invoke(): Result<List<EPICDomainModel>?> = resultLauncher {
        repository.fetchData()?.map(EPICDomainRepoModelMapper::mapFrom)
    }
}