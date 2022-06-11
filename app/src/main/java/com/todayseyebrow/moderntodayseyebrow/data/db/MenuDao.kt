package com.todayseyebrow.moderntodayseyebrow.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.todayseyebrow.moderntodayseyebrow.data.model.Menu

@Dao
interface MenuDao {
    @Query("SELECT * FROM menus ORDER BY itemName DESC")
    fun getAllMenus(): LiveData<List<Menu>>

    @Query("SELECT * FROM menus WHERE category LIKE '%' || :categoryName || '%'")
    fun getMenusByCategory(categoryName: String): LiveData<List<Menu>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(menu: Menu)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(menus: List<Menu>)

}