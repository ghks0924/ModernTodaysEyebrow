package com.todayseyebrow.moderntodayseyebrow.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.todayseyebrow.moderntodayseyebrow.data.model.Message

@Dao
interface MessageDao {

    @Query("SELECT * FROM messages ORDER BY date DESC")
    fun getAllMessages(): LiveData<List<Message>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(messageEntity: Message)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMsgList(messageList: List<Message>)

    @Query("SELECT * FROM messages WHERE id LIKE :key")
    fun findByKey(key: String): Message

    @Update
    fun updateMsg(messageEntity: Message)

    @Delete
    fun delete(messageEntity: Message)

    @Delete
    fun deleteMsgs(msgList: List<Message>)

    @Query("DELETE FROM messages WHERE id LIKE :key ")
    fun deleteMsgByKey(key: String)
}