package com.oleksandr.common.extension

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Calendar.DAY_OF_YEAR
import java.util.Calendar.MONTH
import java.util.Calendar.YEAR
import java.util.Date
import java.util.Locale

const val PATTERN_DATE_TIME_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'" // 2024-04-19T06:24:54.897Z
const val PATTERN_DATE_DIGITS_FULL_FORMAT = "dd.MM.yyyy" // 24.02.2022
const val PATTERN_DATE_SLASHED_DIGITS_FULL_FORMAT = "yyyy/MM/dd" // 2022/24/02
const val PATTERN_DATE_DIGITS_YEAR_MONTH_DAY = "yyyy-MM-dd" // 2022-02-22
const val PATTERN_DATE_DASHED_DIGITS_FULL_WITH_TIME_FORMAT =
    "dd-MM-yyyy, HH:mm" // 29-09-2021, 10:30
const val PATTERN_DATE_DOTTED_DIGITS_FULL_WITH_TIME_FORMAT =
    "dd.MM.yyyy, HH:mm" // 29-09-2021, 10:30
const val PATTERN_DATE_FULL_MONTH_AND_YEAR = "MMMM yyyy" // March 2021
const val PATTERN_DATE_TIME = "HH:mm" // 15:11
const val PATTERN_DAY_MONTH = "dd.MM" // 16.07

fun Date.dateFrom(pattern: String = PATTERN_DATE_DIGITS_FULL_FORMAT, locale: Locale = Locale("uk", "UA")): String {
    return SimpleDateFormat(
        pattern,
        locale,
    ).format(this)
}

fun Date.isToday(): Boolean {
    val cal1 = Calendar.getInstance()
    val cal2 = Calendar.getInstance()
    cal1.time = Date()
    cal2.time = this
    return (cal1[YEAR] == cal2[YEAR]) &&
            (cal1[DAY_OF_YEAR] == cal2[DAY_OF_YEAR])
}

fun Date.isTomorrow(): Boolean {
    val cal1 = Calendar.getInstance()
    val cal2 = Calendar.getInstance()
    cal1.time = Date()
    cal1.add(DAY_OF_YEAR, 1)
    cal2.time = this
    return (cal1[YEAR] == cal2[YEAR]) &&
            (cal1[DAY_OF_YEAR] == cal2[DAY_OF_YEAR])
}

fun Date.isTomorrowOrFuture(): Boolean {
    val cal1 = Calendar.getInstance()
    val cal2 = Calendar.getInstance()
    cal1.time = Date()
    cal2.time = this
    return (cal1[DAY_OF_YEAR] < cal2[DAY_OF_YEAR]) && ((cal1[YEAR] == cal2[YEAR]) ||
            (cal1[YEAR] < cal2[YEAR]))
}

fun Date.isTheSameDay(date: Date?): Boolean {
    val cal1 = Calendar.getInstance()
    val cal2 = Calendar.getInstance()
    cal1.time = date
    cal2.time = this
    return (cal1[YEAR] == cal2[YEAR]) &&
            (cal1[DAY_OF_YEAR] == cal2[DAY_OF_YEAR])
}

fun Date.getFullMonth(forms: Array<String>): String {
    val cal1 = Calendar.getInstance()
    cal1.time = this
    return forms[cal1[MONTH]]
}

fun Date.getYearFromDate(): String {
    val cal1 = Calendar.getInstance()
    cal1.time = this
    return cal1[YEAR].toString()
}