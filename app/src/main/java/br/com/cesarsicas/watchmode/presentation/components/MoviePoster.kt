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
import br.com.cesarsicas.watchmode.model.Movie
import br.com.cesarsicas.watchmode.model.moviesSample

@Composable
fun MoviePoster(
    movie: Movie,
    onMovieClick: (Movie) -> Unit
) {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onMovieClick(movie)
            },
        contentScale = ContentScale.FillWidth,
        painter = painterResource(id = R.drawable.poster_sample),
        contentDescription = movie.title
    )

//    AsyncImage(
//        modifier = Modifier.fillMaxSize(),
//        contentScale = ContentScale.FillWidth,
//        model = movie.poster,
//        contentDescription = movie.title
//    )


}

@Preview
@Composable
private fun MoviePosterPreview() {
    MoviePoster(movie = moviesSample.first(),{})
}