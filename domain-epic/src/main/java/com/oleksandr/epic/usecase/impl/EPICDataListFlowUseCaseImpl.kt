package com.oleksandr.epic.usecase.impl

import com.oleksandr.common.extension.withListMapper
import com.oleksandr.common.extension.withReverseListMapper
import com.oleksandr.epic.mapper.EPICDomainRepoModelMapper
import com.oleksandr.epic.repository.EPICRepository
import com.oleksandr.epic.usecase.EPICDataListFlowUseCase

class EPICDataListFlowUseCaseImpl(
    private val repository: EPICRepository,
    private val mapper: EPICDomainRepoModelMapper,
) : EPICDataListFlowUseCase {
    override fun invoke() = repository.dataList.withReverseListMapper(mapper)
}