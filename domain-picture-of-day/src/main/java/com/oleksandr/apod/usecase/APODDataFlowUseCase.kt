package com.oleksandr.apod.usecase

import com.oleksandr.apod.model.PictureOfDayDomainModel
import kotlinx.coroutines.flow.Flow

interface APODDataFlowUseCase {
    operator fun invoke(): Flow<PictureOfDayDomainModel?>
}