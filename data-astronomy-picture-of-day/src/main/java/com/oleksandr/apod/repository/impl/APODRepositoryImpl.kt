package com.oleksandr.apod.repository.impl

import com.oleksandr.apod.mapper.APODNetPreferenceModelMapper
import com.oleksandr.apod.mapper.APODRepoPreferenceModelMapper
import com.oleksandr.apod.model.APODNetModel
import com.oleksandr.apod.model.APODRepoModel
import com.oleksandr.apod.repository.APODRepository
import com.oleksandr.apod.source.APODNetSource
import com.oleksandr.data.preference.PictureOfDayDataSource
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class APODRepositoryImpl(
    private val apodNetSource: APODNetSource,
    private val pictureOfDayPreferenceDataSource: PictureOfDayDataSource,
) : APODRepository {
    override val data: Flow<APODRepoModel?> =
        pictureOfDayPreferenceDataSource.subscribeToData()
            .map { it?.let(APODRepoPreferenceModelMapper::mapFrom) }

    override suspend fun updateData() {
        val response = apodNetSource.fetchAPOD().body<APODNetModel>()
        pictureOfDayPreferenceDataSource.updateData(
            response.let(APODNetPreferenceModelMapper::mapTo)
        )
    }
}