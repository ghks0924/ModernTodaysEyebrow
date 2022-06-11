package com.todayseyebrow.moderntodayseyebrow.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "messages")
@Parcelize
data class Message(
    @Embedded(prefix = "messagegroup") var group: MessageGroup,
    @ColumnInfo(name = "title") var messageTitle: String,
    @ColumnInfo(name = "content") var messageContent: String,
    @ColumnInfo(name = "date") var messageDate: String,
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") var messageId: String,
    @ColumnInfo(name = "isChecked") var isChecked: Boolean
) : Parcelable