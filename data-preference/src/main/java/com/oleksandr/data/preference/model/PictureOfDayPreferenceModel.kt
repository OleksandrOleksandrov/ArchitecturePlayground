package com.oleksandr.data.preference.model
import com.oleksandr.data.preference.model.base.BasePreferenceModel
import kotlinx.serialization.Serializable

/**
 * Data class representing picture of a day preferences.
 *
 * @property date The date of the picture.
 * @property explanation The explanation of the picture.
 * @property hdurl The URL of the high definition picture.
 * @property mediaType The media type of the picture.
 * @property title The title of the picture.
 * @property url The URL of the picture.
 * @property thumbs The thumbs of the video.
 */
@Serializable
data class PictureOfDayPreferenceModel(
    val date: String,
    val explanation: String,
    val hdurl: String,
    val mediaType: String,
    val title: String,
    val url: String,
    val thumbs: String,
) : BasePreferenceModel
