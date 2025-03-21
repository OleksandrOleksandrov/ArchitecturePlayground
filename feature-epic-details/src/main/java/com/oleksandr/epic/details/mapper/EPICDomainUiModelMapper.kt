package com.oleksandr.epic.details.mapper

import android.icu.util.Calendar
import com.oleksandr.common.extension.PATTERN_DATE_DIGITS_YEAR_MONTH_DAY
import com.oleksandr.common.extension.PATTERN_DATE_SLASHED_DIGITS_FULL_FORMAT
import com.oleksandr.common.extension.dateFrom
import com.oleksandr.common.extension.parseToDate
import com.oleksandr.common.mapper.BaseMapper
import com.oleksandr.epic.model.EPICDomainModel
import com.oleksandr.presentation.core.model.EpicUiModel

class EPICDomainUiModelMapper : BaseMapper<EPICDomainModel, EpicUiModel> {
    override fun mapFrom(model: EpicUiModel) = with(model) {
        EPICDomainModel(
            identifier = identifier,
            caption = caption,
            image = image,
            date = date,
        )
    }

    override fun mapTo(model: EPICDomainModel) = with(model) {
        val calendar = Calendar.getInstance()
        calendar.time = date?.parseToDate(PATTERN_DATE_DIGITS_YEAR_MONTH_DAY)
        EpicUiModel(
            identifier = identifier,
            caption = caption,
            image = "https://api.nasa.gov/EPIC/archive/natural/${calendar.time.dateFrom(PATTERN_DATE_SLASHED_DIGITS_FULL_FORMAT)}/thumbs/${image}.jpg?api_key=3SXKZBBq6vEmA7yamongiBY66cvnlx1JbeeDOtZu",
            date = date,
        )
    }
}