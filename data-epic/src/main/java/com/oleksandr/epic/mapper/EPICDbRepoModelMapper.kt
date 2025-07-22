package com.oleksandr.epic.mapper

import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.database.model.EPICDbModel
import com.oleksandr.epic.model.EPICRepoModel

object EPICDbRepoModelMapper : BaseMapper<EPICDbModel, EPICRepoModel> {
    override fun mapTo(model: EPICDbModel) = with(model) {
        EPICRepoModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }

    override fun mapFrom(model: EPICRepoModel) = with(model) {
        EPICDbModel(
            identifier = identifier ?: "",
            caption = caption,
            image = image,
            date = date,
        )
    }
}