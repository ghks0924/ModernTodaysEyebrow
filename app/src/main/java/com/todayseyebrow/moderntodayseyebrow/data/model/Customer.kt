package com.todayseyebrow.moderntodayseyebrow.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "customers")
@Parcelize
data class Customer(
    @ColumnInfo(name = "customerName") var customerName: String,
    @ColumnInfo(name = "customerNumber") var customerNumber: String,
    @ColumnInfo(name = "customerMemo") var customerMemo: String,
    @ColumnInfo(name = "history") var history: Int,
    @ColumnInfo(name = "grade") var grade: String,
    @ColumnInfo(name = "savedate") var savedate: String,
    @ColumnInfo(name = "noshowCount") var noshowCount: Int,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var customerId: String,
    @ColumnInfo(name = "sales") var sales: Int,
    @ColumnInfo(name = "photoURL") var photoURL: String
) : Parcelable