package br.com.cesarsicas.watchmode.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.cesarsicas.watchmode.screens.FavoritesScreen

internal const val favoritesScreenRoute = "favorites"


fun NavGraphBuilder.favoritesScreen() {

    composable(favoritesScreenRoute) {
        FavoritesScreen()
    }
}

fun NavController.navigateToFavoritesScreen(
    navOptions: NavOptions? = null
) {
    navigate(favoritesScreenRoute, navOptions)

}