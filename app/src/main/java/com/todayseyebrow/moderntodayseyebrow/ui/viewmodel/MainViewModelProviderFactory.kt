package com.todayseyebrow.moderntodayseyebrow.ui.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.todayseyebrow.moderntodayseyebrow.data.repository.TotalRepository

class MainViewModelProviderFactory(
    private val totalRepository: TotalRepository,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(totalRepository, handle) as T
        }
        throw IllegalArgumentException("ViewModel class not found")
    }
}