package com.oleksandr.impl.mapper

import com.oleksandr.architectureplayground.data.preference.impl.model.PictureOfDayProtoModel
import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.data.preference.model.PictureOfDayPreferenceModel

object PictureOfDayPreferenceProtoMapper : BaseMapper<PictureOfDayPreferenceModel, PictureOfDayProtoModel> {
    override fun mapFrom(model: PictureOfDayProtoModel): PictureOfDayPreferenceModel = PictureOfDayPreferenceModel(
        date = model.date,
        explanation = model.explanation,
        hdurl = model.hdurl,
        mediaType = model.mediaType,
        title = model.title,
        url = model.url,
    )

    override fun mapTo(model: PictureOfDayPreferenceModel): PictureOfDayProtoModel = PictureOfDayProtoModel
        .newBuilder()
        .setDate(model.date)
        .setExplanation(model.explanation)
        .setHdurl(model.hdurl)
        .setMediaType(model.mediaType)
        .setTitle(model.title)
        .setUrl(model.url)
        .build()
}