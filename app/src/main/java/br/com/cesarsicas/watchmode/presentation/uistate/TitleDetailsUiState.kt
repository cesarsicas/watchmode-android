package br.com.cesarsicas.watchmode.presentation.uistate

import br.com.cesarsicas.watchmode.domain.Title

data class TitleDetailsUiState(
    val title: Title? = null,
    val isLoading: Boolean = false,
    val error: String? = null

)