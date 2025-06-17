package com.oleksandr.presentation.core.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Immutable
@Parcelize
data class EpicUiModel(
    val identifier: String? = null,
    val caption: String? = null,
    val image: String? = null,
    val date: String? = null,
) : Parcelable

