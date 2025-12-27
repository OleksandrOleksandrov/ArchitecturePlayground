package com.oleksandr.epic.mapper

import android.icu.util.Calendar
import com.oleksandr.common.extension.PATTERN_DATE_DIGITS_YEAR_MONTH_DAY
import com.oleksandr.common.extension.parseToDate
import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.database.model.EPICDbModel
import com.oleksandr.epic.model.EPICNetModel

object EPICDbModelMapper : BaseMapper<EPICDbModel, EPICNetModel> {
    override fun mapTo(model: EPICDbModel) = with(model) {
        val calendar = Calendar.getInstance()
        calendar.time = date?.parseToDate(PATTERN_DATE_DIGITS_YEAR_MONTH_DAY)
        EPICNetModel(
            identifier = identifier,
            caption = caption,
            image = makeFullImageUrl(image, date),
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