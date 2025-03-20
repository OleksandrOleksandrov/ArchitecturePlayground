package com.oleksandr.apod.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * JSON example:
 * ```
 * {
 *  "date": "2025-03-09",
 *  "explanation": "Why are there so many cyclones around the north pole of Jupiter? The topic is still being researched.  NASA's robotic Juno mission orbiting Jupiter took data in 2018 that was used to construct this stunning view of the curious cyclones at Jupiter's north pole. Measuring the thermal emission from Jovian cloud tops, the infrared observations are not restricted to the hemisphere illuminated by sunlight. They reveal eight cyclonic features that surround a cyclone about 4,000 kilometers in diameter, just offset from the giant planet's geographic north pole. Similar data show a cyclone at the Jovian south pole with five circumpolar cyclones. The south pole cyclones are slightly larger than their northern cousins. Oddly, data from the once Saturn-orbiting Cassini mission has shown that Saturn's north and south poles each have only a single cyclonic storm system.",
 *  "hdurl": "https://apod.nasa.gov/apod/image/2503/JupiterCyclones_Juno_2362.jpg",
 *  "media_type": "image",
 *  "service_version": "v1",
 *  "title": "Cyclones at Jupiter's North Pole",
 *  "url": "https://apod.nasa.gov/apod/image/2503/JupiterCyclones_Juno_960.jpg"
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
)
