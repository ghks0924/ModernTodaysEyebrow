package com.todayseyebrow.moderntodayseyebrow.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.todayseyebrow.moderntodayseyebrow.data.model.Message

@Database(
    entities = [Message::class],
    version = 1,
    exportSchema = false
)
abstract class MessageDatabase : RoomDatabase() {

    abstract fun messageDao(): MessageDao

    companion object {
        @Volatile
        private var INSTANCE: MessageDatabase? = null

        private fun buildDatabase(context: Context): MessageDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                MessageDatabase::class.java,
                "messages"
            ).build()

        fun getInstance(context: Context): MessageDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

    }
}