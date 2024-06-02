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
    modifier: Modifier = Modifier,
    title: Title,
    onMovieClick: (Title) -> Unit
) {
    AsyncImage(
        modifier = modifier
            .fillMaxSize()
            .clickable {
                onMovieClick(title)
            },
        model = title.poster,
        contentScale = ContentScale.FillWidth,
        error = painterResource( R.drawable.new_placeholder),
        placeholder = painterResource(id = R.drawable.new_placeholder),
        contentDescription = title.title
    )
}

@Preview
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        modifier = Modifier,
        title = titlesSample.first()
    ) {}
}