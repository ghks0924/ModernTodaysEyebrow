package com.todayseyebrow.moderntodayseyebrow.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "events")
@Parcelize
data class Event(
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "time") var time: String,
    @ColumnInfo(name = "complete") var complete: Boolean,
    @ColumnInfo(name = "customerName") var customerName: String,
    @ColumnInfo(name = "customerNumber") var customerNumber: String,
    @ColumnInfo(name = "customerGrade") var customerGrade: String,
    @ColumnInfo(name = "isRetouch") var isRetouch: Boolean,
    @Embedded(prefix = "menu") var menu: Menu,
    @ColumnInfo(name = "price") var price: Int,
    @ColumnInfo(name = "payment") var payment: String,
    @ColumnInfo(name = "reservMemo") var reservMemo: String,
    @ColumnInfo(name = "savedate") var savedate: String,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var eventId: String,
    @ColumnInfo(name = "category") var category: String
) : Parcelable