package br.com.cesarsicas.watchmode.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.cesarsicas.watchmode.presentation.components.MoviesVerticalList
import br.com.cesarsicas.watchmode.presentation.components.SearchTextField
import br.com.cesarsicas.watchmode.domain.titlesSample

@Composable
fun SearchScreen(searchText: String = "") {
    var text by remember {
        mutableStateOf(searchText)
    }

    Column {

        SearchTextField(
            searchText = text,
            onSearchChange = {
                text = it
            },
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
        )


        val searchResult = remember(text) {
            if (text.isNotBlank()) {
                titlesSample.filter { movie ->
                    movie.title.contains(
                        text,
                        ignoreCase = true,
                    ) ||
                            movie.plot?.contains(
                                text,
                                ignoreCase = true,
                            ) ?: false
                }
            } else emptyList()
        }

        MoviesVerticalList(titles = searchResult)
    }


}


@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen()
}


@Preview(showBackground = true)
@Composable
private fun SearchScreenPreviewWithValue() {
    SearchScreen("The")
}





