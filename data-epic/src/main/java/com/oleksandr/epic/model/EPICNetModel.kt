package com.oleksandr.epic.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EPICNetModel(
    @SerialName("identifier")
    val identifier: String? = null,
    @SerialName("caption")
    val caption: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("date")
    val date: String? = null,
)
