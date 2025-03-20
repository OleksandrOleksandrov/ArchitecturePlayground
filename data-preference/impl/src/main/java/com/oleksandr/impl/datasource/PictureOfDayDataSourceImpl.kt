package com.oleksandr.impl.datasource

import com.oleksandr.data.preference.PictureOfDayDataSource
import com.oleksandr.data.preference.model.PictureOfDayPreferenceModel
import com.oleksandr.impl.mapper.PictureOfDayPreferenceProtoMapper
import com.oleksandr.impl.source.PictureOfDayPreferenceDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class PictureOfDayDataSourceImpl(
    private val dao: PictureOfDayPreferenceDao,
) : PictureOfDayDataSource {
    override fun subscribeToData(): Flow<PictureOfDayPreferenceModel?> =
        dao.subscribeToData().map { it?.let(PictureOfDayPreferenceProtoMapper::mapFrom) }

    override suspend fun getData(): PictureOfDayPreferenceModel? =
        dao.getData()?.let(PictureOfDayPreferenceProtoMapper::mapFrom)

    override suspend fun updateData(value: PictureOfDayPreferenceModel?) =
        dao.updateData(value?.let(PictureOfDayPreferenceProtoMapper::mapTo))
}