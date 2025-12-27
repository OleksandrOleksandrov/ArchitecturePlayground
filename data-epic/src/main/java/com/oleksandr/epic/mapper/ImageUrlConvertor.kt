package com.oleksandr.epic.mapper

import android.icu.util.Calendar
import com.oleksandr.common.extension.PATTERN_DATE_DIGITS_YEAR_MONTH_DAY
import com.oleksandr.common.extension.PATTERN_DATE_SLASHED_DIGITS_FULL_FORMAT
import com.oleksandr.common.extension.dateFrom
import com.oleksandr.common.extension.parseToDate
import com.oleksandr.network.BuildConfig

fun makeFullImageUrl(image: String?, date: String?): String {
    val calendar = Calendar.getInstance()
    calendar.time = date?.parseToDate(PATTERN_DATE_DIGITS_YEAR_MONTH_DAY)
    return "https://epic.gsfc.nasa.gov/archive/natural/${
        calendar.time.dateFrom(PATTERN_DATE_SLASHED_DIGITS_FULL_FORMAT)
    }/thumbs/${image}.jpg?api_key=${BuildConfig.NASA_API_KEY}"
}