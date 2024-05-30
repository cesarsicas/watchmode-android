package br.com.cesarsicas.watchmode.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.cesarsicas.watchmode.data.api.Repository
import br.com.cesarsicas.watchmode.presentation.uistate.ReleasesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReleasesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ReleasesUiState())
    val uiState = _uiState.asStateFlow()

    init {


        viewModelScope.launch {

//        _uiState.update {
//            it.copy(releases = moviesSample)
//        }

            val repository = Repository()

            try {
                val result = repository.getReleases()

                _uiState.update {
                    it.copy(releases = result)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}