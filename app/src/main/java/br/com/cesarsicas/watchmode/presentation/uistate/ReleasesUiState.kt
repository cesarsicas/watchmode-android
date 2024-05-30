package br.com.cesarsicas.watchmode.presentation.uistate

import br.com.cesarsicas.watchmode.domain.Movie

data class ReleasesUiState(
    val releases: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null

)