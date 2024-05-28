package br.com.cesarsicas.watchmode.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.cesarsicas.watchmode.model.Movie
import br.com.cesarsicas.watchmode.screens.ReleasesScreen

internal const val releasesListNavigationRoutes = "releases"


fun NavGraphBuilder.releasesListScreen(
    onNavigateToMovieDetails: (Movie) -> Unit
) {

    composable(releasesListNavigationRoutes) {
        ReleasesScreen()
    }

}


fun NavController.navigateToReleasesList(
    navOptions: NavOptions? = null
) {
    navigate(releasesListNavigationRoutes, navOptions)
}
