package br.com.cesarsicas.watchmode.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cesarsicas.watchmode.presentation.components.MoviePoster
import br.com.cesarsicas.watchmode.domain.Title
import br.com.cesarsicas.watchmode.domain.titlesSample
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

@Composable
fun MovieGrid(
    titles: List<Title>,
    onMovieClick: (Title) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),

        ) {
        items(titles.size) { index ->
            MoviePoster(title = titles[index], onMovieClick = onMovieClick)
        }
    }
}

