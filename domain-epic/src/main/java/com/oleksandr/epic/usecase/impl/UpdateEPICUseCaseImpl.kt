package com.oleksandr.epic.usecase.impl

import com.oleksandr.epic.repository.EPICRepository
import com.oleksandr.epic.usecase.UpdateEPICUseCase

class UpdateEPICUseCaseImpl(
    private val repository: EPICRepository,
) : UpdateEPICUseCase {
    override suspend fun invoke() {
        repository.updateData()
    }
}