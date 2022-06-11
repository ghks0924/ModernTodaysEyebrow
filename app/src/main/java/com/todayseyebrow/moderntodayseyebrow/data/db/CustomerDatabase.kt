package com.todayseyebrow.moderntodayseyebrow.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.todayseyebrow.moderntodayseyebrow.data.model.Customer

@Database(
    entities = [Customer::class],
    version = 1,
    exportSchema = false
)
abstract class CustomerDatabase : RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object {

        @Volatile
        private var INSTANCE: CustomerDatabase? = null

        private fun buildDatabase(context: Context): CustomerDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                CustomerDatabase::class.java,
                "customers"
            ).build()

        fun getInstance(context: Context): CustomerDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

    }
}