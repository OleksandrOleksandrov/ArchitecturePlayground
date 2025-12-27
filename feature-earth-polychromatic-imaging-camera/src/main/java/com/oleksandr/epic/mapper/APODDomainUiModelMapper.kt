package com.oleksandr.epic.mapper

import com.oleksandr.apod.model.PictureOfDayDomainModel
import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.presentation.core.model.PictureOfDayUiModel

object APODDomainUiModelMapper : BaseMapper<PictureOfDayDomainModel, PictureOfDayUiModel> {
    override fun mapTo(model: PictureOfDayDomainModel): PictureOfDayUiModel =
        PictureOfDayUiModel(
            date = model.date,
            explanation = model.explanation,
            hdurl = model.hdurl,
            mediaType = model.mediaType,
            title = model.title,
            url = model.url,
            thumbs = model.thumbs,
        )


    override fun mapFrom(model: PictureOfDayUiModel): PictureOfDayDomainModel =
        PictureOfDayDomainModel(
            date = model.date,
            explanation = model.explanation,
            hdurl = model.hdurl,
            mediaType = model.mediaType,
            title = model.title,
            url = model.url,
            thumbs = model.thumbs,
        )
}