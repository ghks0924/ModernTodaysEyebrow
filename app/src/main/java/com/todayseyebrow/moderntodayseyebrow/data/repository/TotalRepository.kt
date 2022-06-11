package com.todayseyebrow.moderntodayseyebrow.data.repository

import com.todayseyebrow.moderntodayseyebrow.data.model.Memo
import kotlinx.coroutines.flow.Flow

interface TotalRepository {

    // Room

    /* Memo*/
    suspend fun insertMemo(memo: Memo)

    suspend fun deleteMemo(memo: Memo)

    fun getMemos(): Flow<List<Memo>>

    /* Message */

    /* Customer */

    /* Sales */

    /* Event */


}