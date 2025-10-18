package com.oleksandr.epic.mapper

import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.epic.model.EPICDomainModel
import com.oleksandr.presentation.core.model.EpicUiModel

object EPICDomainUiModelMapper : BaseMapper<EPICDomainModel, EpicUiModel> {
    override fun mapFrom(model: EpicUiModel) = with(model) {
        EPICDomainModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }

    override fun mapTo(model: EPICDomainModel) = with(model) {
        EpicUiModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }
}