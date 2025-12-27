package com.oleksandr.apod.model

data class PictureOfDayDomainModel(
    val date: String,
    val explanation: String,
    val hdurl: String,
    val mediaType: String,
    val title: String,
    val url: String,
    val thumbs: String?,
)
