package com.oleksandr.apod.mapper

import com.oleksandr.apod.model.APODRepoModel
import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.data.preference.model.PictureOfDayPreferenceModel

object APODRepoPreferenceModelMapper : BaseMapper<APODRepoModel, PictureOfDayPreferenceModel> {
    override fun mapFrom(model: PictureOfDayPreferenceModel): APODRepoModel = APODRepoModel(
        date = model.date,
        explanation = model.explanation,
        hdurl = model.hdurl,
        mediaType = model.mediaType,
        title = model.title,
        url = model.url,
    )

    override fun mapTo(model: APODRepoModel): PictureOfDayPreferenceModel = PictureOfDayPreferenceModel(
        date = model.date.orEmpty(),
        explanation = model.explanation.orEmpty(),
        hdurl = model.hdurl.orEmpty(),
        mediaType = model.mediaType.orEmpty(),
        title = model.title.orEmpty(),
        url = model.url.orEmpty(),
        thumbs = model.thumbs.orEmpty(),
    )
}