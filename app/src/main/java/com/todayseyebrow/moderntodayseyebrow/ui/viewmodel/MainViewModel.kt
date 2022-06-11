package com.todayseyebrow.moderntodayseyebrow.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.todayseyebrow.moderntodayseyebrow.data.model.Memo
import com.todayseyebrow.moderntodayseyebrow.data.repository.TotalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val totalRepository: TotalRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    // SavedState
    var query = String()
        set(value) {
            field = value
            savedStateHandle.set(SAVE_STATE_KEY, value)
        }

    // Room

    /* Memo */
    val memos: StateFlow<List<Memo>> = totalRepository.getMemos()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), listOf())

    fun saveMemo(memo: Memo) = viewModelScope.launch(Dispatchers.IO) {
        totalRepository.insertMemo(memo)
    }

    fun deleteMemo(memo: Memo) = viewModelScope.launch(Dispatchers.IO) {
        totalRepository.deleteMemo(memo)
    }

    init {
        query = savedStateHandle.get<String>(SAVE_STATE_KEY) ?: ""
    }

    companion object {
        private const val SAVE_STATE_KEY = "query"
    }
}