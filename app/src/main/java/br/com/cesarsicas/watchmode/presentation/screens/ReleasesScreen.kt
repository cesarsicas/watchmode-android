package br.com.cesarsicas.watchmode.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.cesarsicas.watchmode.domain.Title
import br.com.cesarsicas.watchmode.domain.titlesSample
import br.com.cesarsicas.watchmode.presentation.components.MovieGrid
import br.com.cesarsicas.watchmode.presentation.uistate.ReleasesUiState


@Composable
fun ReleasesScreen(
    uiState: ReleasesUiState,
    onMovieClick: (Title) -> Unit = {}
) {
    MovieGrid(
        uiState.releases,
        onMovieClick = onMovieClick
    )

}


@Preview(showBackground = true)
@Composable
private fun ReleasesScreenPreview() {
    ReleasesScreen(uiState = ReleasesUiState(titlesSample))
}

