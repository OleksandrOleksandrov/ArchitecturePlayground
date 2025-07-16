package com.oleksandr.epic.repository.impl

import com.oleksandr.common.extension.withNullableListMapper
import com.oleksandr.database.source.datasource.EPICDbDataSource
import com.oleksandr.epic.mapper.EPICDbModelMapper
import com.oleksandr.epic.mapper.EPICDbRepoModelMapper
import com.oleksandr.epic.model.EPICNetModel
import com.oleksandr.epic.model.EPICRepoModel
import com.oleksandr.epic.repository.EPICRepository
import com.oleksandr.epic.source.EPICNetSource
import io.ktor.client.call.body
import kotlinx.coroutines.flow.Flow

class EPICRepositoryImpl(
    private val epicNetSource: EPICNetSource,
    private val ePICDbRepoModelMapper: EPICDbRepoModelMapper,
    private val dbSource: EPICDbDataSource,
) : EPICRepository {
    override val dataList: Flow<List<EPICRepoModel>?> =
        dbSource.getFlow().withNullableListMapper(ePICDbRepoModelMapper)

    override suspend fun updateData() {
        dbSource.insert(
            EPICDbModelMapper.mapListFrom(
                epicNetSource.fetchEpic().body<List<EPICNetModel>>()
            )
        )
    }
}