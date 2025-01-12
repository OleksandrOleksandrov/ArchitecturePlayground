package com.oleksandr.common.extension

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun String.parseToDate(pattern: String = PATTERN_DATE_TIME_ISO_8601, isUtc: Boolean = true): Date {
    return SimpleDateFormat(
        pattern,
        Locale.getDefault(),
    ).apply {
        if (isUtc) timeZone = TimeZone.getTimeZone("UTC")
    }.parse(this)
}