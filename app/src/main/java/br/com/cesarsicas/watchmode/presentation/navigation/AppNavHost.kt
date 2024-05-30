package br.com.cesarsicas.watchmode.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import br.com.cesarsicas.watchmode.presentation.components.BottomAppBarItem


@Composable
fun AppNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = releasesListNavigationRoutes
    ) {

        releasesListScreen(
            onMovieClick = {
                navController.navigateToTitleDetails(it.id)
            }
        )

        searchScreen()

        favoritesScreen()

        titleDetailsScreen(){
            //navController.popBackStack()
        }

    }

}


fun NavController.navigateSingleTopWithPopUpTo(
    item: BottomAppBarItem
) {
    val (route, navigate) = when (item) {
        BottomAppBarItem.Releases -> Pair(
            releasesListNavigationRoutes,
            ::navigateToReleasesList
        )

        BottomAppBarItem.Search -> Pair(
            searchScreenRoute,
            ::navigateToSearchScreen
        )

        BottomAppBarItem.Favorites -> Pair(
            favoritesScreenRoute,
            ::navigateToFavoritesScreen
        )
    }

    val navOptions = navOptions {
        launchSingleTop = true
        popUpTo(route)
    }
    navigate(navOptions)
}