package com.todayseyebrow.moderntodayseyebrow.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "messagegroups")
@Parcelize
data class MessageGroup(
    @ColumnInfo(name = "name") var groupName: String,
    @ColumnInfo(name = "num") var numberOfMessages: Int,
    @ColumnInfo(name = "order") var order: Int,
    @ColumnInfo(name = "savedate") var savedate: String,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var messageGroupId: String,
    @ColumnInfo(name = "deletecheck") var deleteCheck: Boolean
) : Parcelable