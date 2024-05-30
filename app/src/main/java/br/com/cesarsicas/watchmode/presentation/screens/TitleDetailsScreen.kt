package br.com.cesarsicas.watchmode.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cesarsicas.watchmode.R
import br.com.cesarsicas.watchmode.domain.titlesSample
import br.com.cesarsicas.watchmode.presentation.uistate.TitleDetailsUiState
import coil.compose.AsyncImage


@Preview
@Composable
private fun TitleDetailsScreenPreview() {
    TitleDetailsScreen(TitleDetailsUiState(title = titlesSample.first()))
}

@Composable
fun TitleDetailsScreen(uiState: TitleDetailsUiState) {
    uiState.title?.let { title ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            AsyncImage(
                modifier = Modifier.height(300.dp),
                model = title.poster,
                alignment = Alignment.Center,
                placeholder = painterResource(id = R.drawable.new_placeholder),
                contentDescription = title.title
            )
            Text(
                modifier = Modifier.padding(top = 32.dp),
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
                text = "${title.title} - (${title.year})"
            )
            Text(
                text = title.plot ?: "",
                modifier = Modifier.padding(top = 16.dp),
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            )

            Text(
                text = ("Gênero: " + title.genreNames?.joinToString(", ")),
                modifier = Modifier.padding(top = 16.dp),
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            )

            title.userRating?.let {
                Text(
                    text = ("Avaliação de Usuários: " + title.userRating),
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
            }

            title.criticScore?.let {
                Text(
                    text = ("Avaliação de Críticos: " + title.criticScore),
                    modifier = Modifier.padding(top = 16.dp),
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
            }

        }
    }
}
