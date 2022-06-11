package com.todayseyebrow.moderntodayseyebrow.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "menus")
@Parcelize
data class Menu(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var menuId: String,
    @ColumnInfo(name = "category") var category: String,
    @ColumnInfo(name = "itemName") var itemName: String,
    @ColumnInfo(name = "productName") var productName: String,
    @ColumnInfo(name = "savedate") var savedate: String
) : Parcelable