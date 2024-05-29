package br.com.cesarsicas.watchmode.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
private fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}

@Composable
fun MovieDetailsScreen() {
    Text(text = "Movie details :)")
}
