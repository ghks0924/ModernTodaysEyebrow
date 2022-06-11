package com.todayseyebrow.moderntodayseyebrow.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.todayseyebrow.moderntodayseyebrow.data.model.Category

@Database(
    entities = [Category::class],
    version = 1,
    exportSchema = false
)
abstract class CategoryDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao

    companion object {

        @Volatile
        private var INSTANCE: CategoryDatabase? = null

        private fun buildDatabase(context: Context): CategoryDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                CategoryDatabase::class.java,
                "categories"
            ).build()

        fun getInstance(context: Context): CategoryDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

    }
}