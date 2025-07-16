package com.oleksandr.epic.mapper

import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.database.model.EPICDbModel
import com.oleksandr.epic.model.EPICNetModel

object EPICDbModelMapper : BaseMapper<EPICDbModel, EPICNetModel> {
    override fun mapTo(model: EPICDbModel) = with(model) {
        EPICNetModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }

    override fun mapFrom(model: EPICNetModel) = with(model) {
        EPICDbModel(
            identifier = identifier ?: "",
            caption = caption,
            image = image,
            date = date,
        )
    }
}