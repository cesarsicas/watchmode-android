package br.com.cesarsicas.watchmode.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.cesarsicas.watchmode.R
import br.com.cesarsicas.watchmode.domain.Movie
import br.com.cesarsicas.watchmode.domain.moviesSample
import coil.compose.AsyncImage

@Composable
fun MoviePoster(
    movie: Movie,
    onMovieClick: (Movie) -> Unit
) {
    AsyncImage(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onMovieClick(movie)
            },
        model = movie.poster,
        contentScale = ContentScale.FillWidth,
        placeholder = painterResource(id = R.drawable.poster_placeholder),
        contentDescription = movie.title
    )
}

@Preview
@Composable
private fun MoviePosterPreview() {
    MoviePoster(movie = moviesSample.first(),{})
}