package com.todayseyebrow.moderntodayseyebrow.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.todayseyebrow.moderntodayseyebrow.data.model.Memo

@Database(
    entities = [Memo::class],
    version = 1,
    exportSchema = false
)
abstract class MemoDatabase : RoomDatabase() {

    abstract fun memoDao(): MemoDao

    companion object {

        @Volatile
        private var INSTANCE: MemoDatabase? = null

        private fun buildDatabase(context: Context): MemoDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                MemoDatabase::class.java,
                "memos"
            ).build()

        fun getInstance(context: Context): MemoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

    }
}