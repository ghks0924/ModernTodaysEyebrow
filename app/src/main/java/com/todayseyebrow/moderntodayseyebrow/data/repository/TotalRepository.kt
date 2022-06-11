package com.todayseyebrow.moderntodayseyebrow.data.repository

import com.todayseyebrow.moderntodayseyebrow.data.model.Memo
import com.todayseyebrow.moderntodayseyebrow.data.model.Message
import kotlinx.coroutines.flow.Flow

interface TotalRepository {

    // Room

    /* Memo*/
    suspend fun insertMemo(memo: Memo)

    suspend fun deleteMemo(memo: Memo)

    fun getMemos(): Flow<List<Memo>>

    /* Message */
    suspend fun insertMessage(message: Message)

    suspend fun deleteMessage(message: Message)

    /* Customer */

    /* Sales */

    /* Event */


}