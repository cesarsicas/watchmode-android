package br.com.cesarsicas.watchmode.screens

import androidx.compose.foundation.layout.Arrangement
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
fun ReleasesScreen(
    modifier: Modifier = Modifier,
    onMovieClick: (Movie) -> Unit = {}
) {
    MovieGrid(
        moviesSample,
        onMovieClick = onMovieClick
    )

}


@Preview(showBackground = true)
@Composable
private fun ReleasesScreenPreview() {
    ReleasesScreen()
}

@Composable
fun MovieGrid(
    movies: List<Movie>,
    onMovieClick: (Movie) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp),

        ) {
        items(movies.size) { index ->
            MoviePoster(movie = movies[index], onMovieClick = onMovieClick)
        }
    }
}

