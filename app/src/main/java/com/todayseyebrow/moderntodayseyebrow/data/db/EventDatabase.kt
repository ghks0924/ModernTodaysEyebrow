package com.todayseyebrow.moderntodayseyebrow.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.todayseyebrow.moderntodayseyebrow.data.model.Event

@Database(
    entities = [Event::class],
    version = 1,
    exportSchema = false
)
abstract class EventDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object {

        @Volatile
        private var INSTANCE: EventDatabase? = null

        private fun buildDatabase(context: Context): EventDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                EventDatabase::class.java,
                "events"
            ).build()

        fun getInstance(context: Context): EventDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

    }
}