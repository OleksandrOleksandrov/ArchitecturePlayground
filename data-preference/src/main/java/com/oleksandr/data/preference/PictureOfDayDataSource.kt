package com.oleksandr.data.preference

import com.oleksandr.data.preference.model.PictureOfDayPreferenceModel
import kotlinx.coroutines.flow.Flow

interface PictureOfDayDataSource {
    fun subscribeToData(): Flow<PictureOfDayPreferenceModel?>

    suspend fun getData(): PictureOfDayPreferenceModel?

    suspend fun updateData(value: PictureOfDayPreferenceModel?)
}