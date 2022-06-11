package com.todayseyebrow.moderntodayseyebrow.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.todayseyebrow.moderntodayseyebrow.data.model.MessageGroup

@Database(
    entities = [MessageGroup::class],
    version = 1,
    exportSchema = false
)
abstract class MessageGroupDatabase : RoomDatabase() {

    abstract fun messageGroupDao(): MessageGroupDao

    companion object {
        @Volatile
        private var INSTANCE: MessageGroupDatabase? = null

        private fun buildDatabase(context: Context): MessageGroupDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                MessageGroupDatabase::class.java,
                "messagegroups"
            ).build()

        fun getInstance(context: Context): MessageGroupDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

    }
}