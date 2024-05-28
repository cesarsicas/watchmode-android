package br.com.cesarsicas.watchmode

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.cesarsicas.watchmode.components.BottomAppBar
import br.com.cesarsicas.watchmode.components.BottomAppBarItem
import br.com.cesarsicas.watchmode.components.bottomAppBarItems
import br.com.cesarsicas.watchmode.navigation.AppNavHost
import br.com.cesarsicas.watchmode.navigation.favoritesScreenRoute
import br.com.cesarsicas.watchmode.navigation.navigateSingleTopWithPopUpTo
import br.com.cesarsicas.watchmode.navigation.releasesListNavigationRoutes
import br.com.cesarsicas.watchmode.navigation.searchScreenRoute
import br.com.cesarsicas.watchmode.screens.ReleasesScreen
import br.com.cesarsicas.watchmode.ui.theme.BackgroundColor
import br.com.cesarsicas.watchmode.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val backStackEntryState by navController.currentBackStackEntryAsState()
            val currentDestination = backStackEntryState?.destination

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = BackgroundColor
                ) {
                    val currentRoute = currentDestination?.route
                    val selectedItem by remember(currentDestination) {

                        val item = when (currentRoute) {
                            releasesListNavigationRoutes -> BottomAppBarItem.Releases
                            favoritesScreenRoute -> BottomAppBarItem.Favorites
                            searchScreenRoute -> BottomAppBarItem.Search
                            else -> BottomAppBarItem.Releases
                        }
                        mutableStateOf(item)
                    }

                    WatchModeApp(
                        isShowBottomBar = true,
                        isShowTopBar = true,
                        bottomAppBarItemSelected = selectedItem,
                        onBottomAppBarItemSelectedChange = { item ->
                            navController.navigateSingleTopWithPopUpTo(item)
                        },
                        content = {
                            AppNavHost(navController = navController)
                        })
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchModeApp(
    bottomAppBarItemSelected: BottomAppBarItem = bottomAppBarItems.first(),
    onBottomAppBarItemSelectedChange: (BottomAppBarItem) -> Unit = {},
    isShowBottomBar: Boolean = false,
    isShowTopBar: Boolean = false,
    content: @Composable () -> Unit
) {
    Scaffold(
        topBar = {
            if (isShowTopBar) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "Watch Mode")
                    },
                )
            }
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Watch Mode")
                },
            )
        },
        bottomBar = {
            if (isShowBottomBar) {
                BottomAppBar(
                    item = bottomAppBarItemSelected,
                    items = bottomAppBarItems,
                    onItemChange = onBottomAppBarItemSelectedChange,
                )
            }
        },
    ) {
        Box(
            modifier = Modifier.padding(it)
        ) {
            content()
        }
    }
}

@Preview
@Composable
private fun WatchModeAppPreview() {
    MyApplicationTheme {
        Surface {
            WatchModeApp(content = {
                ReleasesScreen()
            })
        }
    }
}