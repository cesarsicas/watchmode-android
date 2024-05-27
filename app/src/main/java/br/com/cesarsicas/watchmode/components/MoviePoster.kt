package br.com.cesarsicas.watchmode.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.cesarsicas.watchmode.R
import br.com.cesarsicas.watchmode.model.Movie
import br.com.cesarsicas.watchmode.model.moviesSample
import coil.compose.AsyncImage

@Composable
fun MoviePoster(movie: Movie) {
    Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillWidth,
        painter = painterResource(id = R.drawable.poster_sample),
        contentDescription = movie.title
    )
//    AsyncImage(
//        model = movie.poster,
//        contentDescription = movie.title
//    )
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
    MoviePoster(movie = moviesSample.first())
}