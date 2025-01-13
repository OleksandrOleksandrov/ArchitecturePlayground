package com.oleksandr.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.oleksandr.database.model.base.BaseDbModel
import com.oleksandr.database.source.PlaygroundDatabase.Table.EPICTable

@Entity(tableName = EPICTable)
data class EPICDbModel(
    @PrimaryKey
    @ColumnInfo("id")
    val identifier: String,
    @ColumnInfo("caption")
    val caption: String? = null,
    @ColumnInfo("image")
    val image: String? = null,
    @ColumnInfo("date")
    val date: String? = null,
) : BaseDbModel
