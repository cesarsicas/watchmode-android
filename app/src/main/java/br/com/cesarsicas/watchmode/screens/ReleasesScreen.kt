package br.com.cesarsicas.watchmode.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cesarsicas.watchmode.components.MoviePoster
import br.com.cesarsicas.watchmode.model.Movie
import br.com.cesarsicas.watchmode.model.moviesSample


@Composable
fun ReleasesScreen(modifier: Modifier = Modifier) {
    MovieGrid(moviesSample)
}


@Preview
@Composable
private fun ReleasesScreenPreview() {
    ReleasesScreen()
}

@Composable
fun MovieGrid(movies: List<Movie>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().padding(4.dp)
    ) {
        items(movies.size) { index ->
            MoviePoster(movie = movies[index])
        }
    }
}

