package com.todayseyebrow.moderntodayseyebrow.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.todayseyebrow.moderntodayseyebrow.data.model.Category

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories ORDER BY id DESC")
    fun getAllCategories(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category)

//    @Query("SELECT * FROM categories WHERE name LIKE :name")
//    fun findByName(name: String) : Category
//
//    @Update
//    fun update(category: Category)
//
//    @Delete
//    fun delete(category: Category)
}