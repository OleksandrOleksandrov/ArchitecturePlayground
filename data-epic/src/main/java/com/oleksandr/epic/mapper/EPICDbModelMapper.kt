package com.oleksandr.epic.mapper

import android.icu.util.Calendar
import com.oleksandr.common.extension.PATTERN_DATE_DIGITS_YEAR_MONTH_DAY
import com.oleksandr.common.extension.PATTERN_DATE_SLASHED_DIGITS_FULL_FORMAT
import com.oleksandr.common.extension.dateFrom
import com.oleksandr.common.extension.parseToDate
import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.database.model.EPICDbModel
import com.oleksandr.epic.model.EPICNetModel
import com.oleksandr.network.BuildConfig

object EPICDbModelMapper : BaseMapper<EPICDbModel, EPICNetModel> {
    override fun mapTo(model: EPICDbModel) = with(model) {
        val calendar = Calendar.getInstance()
        calendar.time = date?.parseToDate(PATTERN_DATE_DIGITS_YEAR_MONTH_DAY)
        EPICNetModel(
            identifier = identifier,
            caption = caption,
            image = "https://epic.gsfc.nasa.gov/archive/natural/${
                calendar.time.dateFrom(
                    PATTERN_DATE_SLASHED_DIGITS_FULL_FORMAT
                )
            }/thumbs/${image}.jpg?api_key=${BuildConfig.NASA_API_KEY}",
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