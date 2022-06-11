package com.todayseyebrow.moderntodayseyebrow.data.db

import androidx.room.*
import com.todayseyebrow.moderntodayseyebrow.data.model.Memo
import kotlinx.coroutines.flow.Flow


@Dao
interface MemoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMemo(memoEntity: Memo)

    @Delete
    fun deleteMemo(memoEntity: Memo)

    @Query("SELECT * FROM memos ORDER BY date DESC")
    fun getMemos(): Flow<List<Memo>>


    @Query("SELECT * FROM memos WHERE date LIKE :date")
    fun findByDate(date: String): Memo

    @Query("UPDATE memos SET isPinned=:isPinned WHERE id = :key")
    fun updateIsPinned(isPinned: Boolean, key: String)

    @Update
    fun update(memoEntity: Memo)


}