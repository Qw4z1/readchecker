package io.nyblom.readchecker

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.nyblom.readchecker.api.apolloClient
import kotlinx.coroutines.launch

data class ReadsState(
    val reads: List<GetReadsQuery.Read>
)

class MainViewModel : ViewModel() {
    var isRefreshing = mutableStateOf(false)
        private set
    var uiState = mutableStateOf(ReadsState(emptyList()))
        private set

    init {
        refresh()
    }

    fun refresh() {
        isRefreshing.value = true
        viewModelScope.launch {
            val response = apolloClient.query(GetReadsQuery()).execute()
            if (!response.hasErrors()) {
                val reads = response.dataAssertNoErrors.reads
                uiState.value = ReadsState(reads)
            }
            isRefreshing.value = false
        }
    }
}