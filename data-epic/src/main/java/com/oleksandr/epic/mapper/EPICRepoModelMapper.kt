package com.oleksandr.epic.mapper

import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.epic.model.EPICNetModel
import com.oleksandr.epic.model.EPICRepoModel

object EPICRepoModelMapper : BaseMapper<EPICNetModel, EPICRepoModel> {
    override fun mapTo(model: EPICNetModel) = with(model) {
        EPICRepoModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }

    override fun mapFrom(model: EPICRepoModel) = with(model) {
        EPICNetModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }
}