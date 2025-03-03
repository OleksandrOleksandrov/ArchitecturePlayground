package com.oleksandr.presentation.core.model

import kotlinx.serialization.Serializable

@Serializable
data class EpicUiModel(
    val identifier: String? = null,
    val caption: String? = null,
    val image: String? = null,
    val date: String? = null,
)
