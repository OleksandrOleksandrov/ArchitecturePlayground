package com.oleksandr.presentation.core.model

import kotlinx.serialization.Serializable

@Serializable
data class PictureOfDayUiModel(
    val date: String,
    val explanation: String,
    val hdurl: String,
    val mediaType: String,
    val title: String,
    val url: String
)
