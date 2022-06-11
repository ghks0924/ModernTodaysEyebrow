package com.todayseyebrow.moderntodayseyebrow.data.repository

import androidx.datastore.core.DataStore
import com.todayseyebrow.moderntodayseyebrow.data.db.MemoDatabase
import com.todayseyebrow.moderntodayseyebrow.data.model.Memo
import kotlinx.coroutines.flow.Flow

class TotalRepositoryImpl(
    private val memoDB: MemoDatabase,
    private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences>

) : TotalRepository {

    /* Memo */
    override suspend fun insertMemo(memo: Memo) {
        memoDB.memoDao().insertMemo(memo)
    }

    override suspend fun deleteMemo(memo: Memo) {
        memoDB.memoDao().deleteMemo(memo)
    }

    override fun getMemos(): Flow<List<Memo>> {
        return memoDB.memoDao().getMemos()
    }

    /* Message */

    /* Customer */

    /* Sales */

    /* Event */

}