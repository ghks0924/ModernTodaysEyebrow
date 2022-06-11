package com.todayseyebrow.moderntodayseyebrow.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.todayseyebrow.moderntodayseyebrow.data.model.Event

@Dao
interface EventDao {

    @Query("SELECT * FROM events ORDER BY date DESC")
    fun getAllEvents(): LiveData<List<Event>>

    @Query("SELECT * FROM events WHERE date LIKE '%' || :yearMonth || '%' ORDER BY date DESC")
    fun getEventsByYearMonth(yearMonth: String): LiveData<List<Event>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(eventEntity: Event)

    @Query("SELECT * FROM events WHERE date LIKE :date")
    fun findByDate(date: String): Event
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(memoEntity : MemoData)

//    @Query("UPDATE memos set date = :date, title = :title, content = :content WHERE idx = :idx")
//    fun update(idx: Int, date : String, title : String?, content : String)

//    @Query("DELETE FROM memos WHERE idx = :idx")
//    fun delete(idx: Int)

    @Update
    fun update(eventEntity: Event)

    @Delete
    fun delete(eventEntity: Event)

}