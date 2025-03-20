package com.oleksandr.apod.usecase.impl

import com.oleksandr.apod.repository.APODRepository
import com.oleksandr.apod.usecase.UpdateAPODUseCase

class UpdateAPODUseCaseImpl(
    private val repository: APODRepository,
) : UpdateAPODUseCase {
    override suspend fun invoke() {
        repository.updateData()
    }
}