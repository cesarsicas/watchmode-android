package br.com.cesarsicas.watchmode.presentation.uistate

import br.com.cesarsicas.watchmode.domain.Title

data class ReleasesUiState(
    val releases: List<Title> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null

)