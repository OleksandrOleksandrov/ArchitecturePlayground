package com.oleksandr.apod.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * JSON example:
 * ```
 * {
 *  "date": "2025-03-09",
 *  "explanation": "Some long explanation",
 *  "hdurl": "https://apod.nasa.gov/apod/image/2503/JupiterCyclones_Juno_2362.jpg",
 *  "media_type": "image",
 *  "service_version": "v1",
 *  "title": "Cyclones at Jupiter's North Pole",
 *  "url": "https://apod.nasa.gov/apod/image/2503/JupiterCyclones_Juno_960.jpg"
 *  "thumbs": "https://apod.nasa.gov/apod/image/2503/JupiterCyclones_Juno_960.jpg"
 * }
 * ```
 */
@Serializable
data class APODNetModel(
    @SerialName("date")
    val date: String? = null,
    @SerialName("explanation")
    val explanation: String? = null,
    @SerialName("hdurl")
    val hdurl: String? = null,
    @SerialName("media_type")
    val mediaType: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("thumbnail_url")
    val thumbs: String? = null,
)
