package com.todayseyebrow.moderntodayseyebrow.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "memos")
@Parcelize
data class Memo(
    @ColumnInfo(name = "date") var memoDate: String,
    @ColumnInfo(name = "title") var memoTitle: String,
    @ColumnInfo(name = "content") var memoContent: String,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var memoId: String,
    @ColumnInfo(name = "isPinned") var isPinned: Boolean,
    @ColumnInfo(name = "isChecked") var isChecked: Boolean
) : Parcelable