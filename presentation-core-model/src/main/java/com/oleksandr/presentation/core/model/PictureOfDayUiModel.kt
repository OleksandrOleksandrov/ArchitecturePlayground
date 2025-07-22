package com.oleksandr.presentation.core.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class PictureOfDayUiModel(
    val date: String,
    val explanation: String,
    val hdurl: String,
    val mediaType: String,
    val title: String,
    val url: String
) : Parcelable
