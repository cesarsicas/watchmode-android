package br.com.cesarsicas.watchmode.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import br.com.cesarsicas.watchmode.presentation.screens.SearchScreen

internal const val searchScreenRoute = "search"

fun NavGraphBuilder.searchScreen() {
    composable(searchScreenRoute) {
        SearchScreen()
    }
}

fun NavController.navigateToSearchScreen(
    navOptions: NavOptions? = null
) {
    navigate(searchScreenRoute, navOptions)
}
