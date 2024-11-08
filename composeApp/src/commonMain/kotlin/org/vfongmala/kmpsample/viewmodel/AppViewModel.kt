package org.vfongmala.kmpsample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.vfongmala.kmpsample.repository.SampleRepository

class AppViewModel(
    private val repository: SampleRepository,
): ViewModel() {

    private val _viewState = MutableStateFlow("")
    val viewState = _viewState

    fun getSample() {
        viewModelScope.launch {
            viewState.value = repository.getSample().message
        }
    }
}