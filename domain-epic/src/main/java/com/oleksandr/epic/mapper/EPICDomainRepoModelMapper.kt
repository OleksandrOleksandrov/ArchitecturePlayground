package com.oleksandr.epic.mapper

import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.epic.model.EPICDomainModel
import com.oleksandr.epic.model.EPICRepoModel

object EPICDomainRepoModelMapper : BaseMapper<EPICDomainModel, EPICRepoModel> {
    override fun mapTo(model: EPICDomainModel) = with(model) {
        EPICRepoModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }

    override fun mapFrom(model: EPICRepoModel) = with(model) {
        EPICDomainModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }
}