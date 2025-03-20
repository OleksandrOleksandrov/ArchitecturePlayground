package com.oleksandr.apod.usecase.impl

import com.oleksandr.apod.model.PictureOfDayDomainModel
import com.oleksandr.apod.repository.APODRepository
import com.oleksandr.apod.usecase.APODDataFlowUseCase
import com.oleksandr.common.extension.mapNonNullValue
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

class APODDataFlowUseCaseImpl(
    private val repository: APODRepository,
) : APODDataFlowUseCase {
    override fun invoke() = repository.data.mapNonNullValue {
        PictureOfDayDomainModel(
            date = it.date.orEmpty(),
            explanation = it.explanation.orEmpty(),
            hdurl = it.hdurl.orEmpty(),
            mediaType = it.mediaType.orEmpty(),
            title = it.title.orEmpty(),
            url = it.url.orEmpty()
        )
    }
}