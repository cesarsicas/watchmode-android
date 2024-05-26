package br.com.cesarsicas.watchmode.components

import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.cesarsicas.watchmode.model.Movie
import br.com.cesarsicas.watchmode.model.moviesSample
import coil.compose.AsyncImage

@Composable
fun MoviePoster(movie: Movie) {
    ElevatedCard() {
        AsyncImage(
            model = movie.poster,
            contentDescription = movie.title
        )
    }

}

@Preview
@Composable
private fun MoviePosterPreview() {
    MoviePoster(movie = moviesSample.first())
}