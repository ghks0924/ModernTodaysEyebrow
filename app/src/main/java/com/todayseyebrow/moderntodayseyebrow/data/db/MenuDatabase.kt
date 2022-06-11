package com.todayseyebrow.moderntodayseyebrow.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.todayseyebrow.moderntodayseyebrow.data.model.Menu

@Database(
    entities = [Menu::class],
    version = 1,
    exportSchema = false
)
abstract class MenuDatabase : RoomDatabase() {

    abstract fun menuDao(): MenuDao

    companion object {

        @Volatile
        private var INSTANCE: MenuDatabase? = null

        private fun buildDatabase(context: Context): MenuDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                MenuDatabase::class.java,
                "menus"
            ).build()

        fun getInstance(context: Context): MenuDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

    }

}