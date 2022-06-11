package com.todayseyebrow.moderntodayseyebrow.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.todayseyebrow.moderntodayseyebrow.data.model.Customer

@Dao
interface CustomerDao {
    
    @Query("SELECT * FROM customers ORDER BY customerName DESC")
    fun getAllCustomers(): LiveData<List<Customer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(customer: Customer)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(customers: List<Customer>)


    @Query("SELECT * FROM customers WHERE customerName LIKE :customerName")
    fun findByName(customerName: String): Customer

    @Query("SELECT * FROM customers WHERE customerNumber LIKE :customerNumber")
    fun findByNumber(customerNumber: String): Customer

    @Query("SELECT * FROM customers WHERE id LIKE :key")
    fun findByKey(key: String): Customer


//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(memoEntity : MemoData)

//    @Query("UPDATE memos set date = :date, title = :title, content = :content WHERE idx = :idx")
//    fun update(idx: Int, date : String, title : String?, content : String)

//    @Query("DELETE FROM memos WHERE idx = :idx")
//    fun delete(idx: Int)

    @Update
    fun update(customer: Customer)

    @Delete
    fun delete(customer: Customer)
}