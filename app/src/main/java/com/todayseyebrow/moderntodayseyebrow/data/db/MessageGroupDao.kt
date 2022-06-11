package com.todayseyebrow.moderntodayseyebrow.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.todayseyebrow.moderntodayseyebrow.data.model.MessageGroup

@Dao
interface MessageGroupDao {

    @Query("SELECT * FROM messagegroups ORDER BY `order` DESC")
    fun getAllGroups(): LiveData<List<MessageGroup>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(msgGrp: MessageGroup)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMsgGrpList(msgGrpList: List<MessageGroup>)

    @Query("SELECT * FROM messagegroups WHERE id LIKE :key")
    fun findByKey(key: String): MessageGroup

    @Update
    suspend fun update(msgGrp: MessageGroup)

    @Delete
    fun delete(msgGrp: MessageGroup)
}