package com.oleksandr.apod.mapper

import com.oleksandr.apod.model.APODNetModel
import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.data.preference.model.PictureOfDayPreferenceModel

object APODNetPreferenceModelMapper : BaseMapper<APODNetModel, PictureOfDayPreferenceModel> {
    override fun mapFrom(model: PictureOfDayPreferenceModel): APODNetModel = APODNetModel(
        date = model.date,
        explanation = model.explanation,
        hdurl = model.hdurl,
        mediaType = model.mediaType,
        title = model.title,
        url = model.url,
        thumbs = model.thumbs,
    )

    override fun mapTo(model: APODNetModel): PictureOfDayPreferenceModel = PictureOfDayPreferenceModel(
        date = model.date.orEmpty(),
        explanation = model.explanation.orEmpty(),
        hdurl = model.hdurl.orEmpty(),
        mediaType = model.mediaType.orEmpty(),
        title = model.title.orEmpty(),
        url = model.url.orEmpty(),
        thumbs = model.thumbs.orEmpty()
    )
}