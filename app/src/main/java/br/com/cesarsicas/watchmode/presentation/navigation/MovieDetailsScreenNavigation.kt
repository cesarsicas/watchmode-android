package br.com.cesarsicas.watchmode.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.cesarsicas.watchmode.domain.Movie
import br.com.cesarsicas.watchmode.presentation.screens.MovieDetailsScreen

internal const val movieDetailsScreenRoute = "movieDetails"

fun NavGraphBuilder.movieDetailsScreen() {
    composable(movieDetailsScreenRoute) {
        MovieDetailsScreen()
    }
}

fun NavController.navigateToMovieDetails(
    movie: Movie,
    navOptions: NavOptions? = null
) {
    navigate(movieDetailsScreenRoute, navOptions)
}
