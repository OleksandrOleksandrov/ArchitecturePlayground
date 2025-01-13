package com.oleksandr.database.impl

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oleksandr.database.impl.source.dao.EPICDao
import com.oleksandr.database.model.EPICDbModel
import com.oleksandr.database.source.PlaygroundDatabase.NAME

const val DB_VERSION = 1

@Database(entities = [EPICDbModel::class], version = DB_VERSION)
abstract class PlaygroundDatabase : RoomDatabase() {
    abstract fun epicDao(): EPICDao

    companion object {
        fun getDb(application: Application): PlaygroundDatabase =
            Room.databaseBuilder(application, PlaygroundDatabase::class.java, NAME).build()
    }
}