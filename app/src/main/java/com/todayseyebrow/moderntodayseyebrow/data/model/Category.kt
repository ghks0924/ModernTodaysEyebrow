package com.todayseyebrow.moderntodayseyebrow.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "categories")
@Parcelize
data class Category(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "savedate") var savedate: String,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var categoryId: String,
    @ColumnInfo(name = "colorInt") var colorInt: Int
) : Parcelable