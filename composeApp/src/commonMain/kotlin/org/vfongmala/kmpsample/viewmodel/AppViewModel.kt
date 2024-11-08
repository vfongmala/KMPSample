package org.vfongmala.kmpsample.viewmodel

import androidx.lifecycle.ViewModel
import org.vfongmala.kmpsample.repository.SampleRepository

class AppViewModel(
    private val repository: SampleRepository,
): ViewModel() {
    fun getSample(): String {
        return repository.getSample().message
    }
}