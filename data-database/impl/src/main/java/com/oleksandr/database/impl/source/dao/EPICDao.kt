package com.oleksandr.database.impl.source.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.oleksandr.database.model.EPICDbModel
import com.oleksandr.database.source.PlaygroundDatabase
import kotlinx.coroutines.flow.Flow

@Dao
interface EPICDao {

    @Query("SELECT * FROM ${PlaygroundDatabase.Table.EPICTable}")
    suspend fun get(): List<EPICDbModel>?

    @Query("SELECT * FROM ${PlaygroundDatabase.Table.EPICTable} WHERE id=:id")
    suspend fun get(id: Long): EPICDbModel?

    @Query("SELECT * FROM ${PlaygroundDatabase.Table.EPICTable}")
    fun subscribe(): Flow<List<EPICDbModel>?>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(value: EPICDbModel): Long

    @Update
    suspend fun update(value: EPICDbModel)

    @Query("DELETE FROM ${PlaygroundDatabase.Table.EPICTable} WHERE id=:id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM ${PlaygroundDatabase.Table.EPICTable}")
    suspend fun deleteAll()
}