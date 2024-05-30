package br.com.cesarsicas.watchmode.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.cesarsicas.watchmode.R
import br.com.cesarsicas.watchmode.domain.Title
import br.com.cesarsicas.watchmode.domain.titlesSample
import coil.compose.AsyncImage

@Composable
fun MoviePoster(
    title: Title,
    onMovieClick: (Title) -> Unit
) {
    AsyncImage(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onMovieClick(title)
            },
        model = title.poster,
        contentScale = ContentScale.FillWidth,
        placeholder = painterResource(id = R.drawable.poster_placeholder),
        contentDescription = title.title
    )
}

@Preview
@Composable
private fun MoviePosterPreview() {
    MoviePoster(title = titlesSample.first(),{})
}