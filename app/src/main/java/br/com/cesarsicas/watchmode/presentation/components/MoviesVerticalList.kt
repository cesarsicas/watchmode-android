package br.com.cesarsicas.watchmode.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cesarsicas.watchmode.R
import br.com.cesarsicas.watchmode.domain.Movie
import br.com.cesarsicas.watchmode.domain.moviesSample
import coil.compose.AsyncImage

@Composable
fun MoviesVerticalList(movies: List<Movie>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 4.dp),

        ) {

        items(movies.size) { i ->
            Column {
                Row {
                    AsyncImage(
                        modifier = Modifier.width(50.dp),
                        model = movies[i].poster,
                        contentScale = ContentScale.FillWidth,
                        placeholder = painterResource(id = R.drawable.poster_placeholder),
                        contentDescription = movies[i].title
                    )

                    Text(modifier = Modifier.padding(start = 4.dp), text = movies[i].title)
                }
                Box(modifier = Modifier.height(6.dp))
            }

        }
    }
}


@Preview
@Composable
private fun MoviesVerticalListPreview() {
    MoviesVerticalList(movies = moviesSample)
}