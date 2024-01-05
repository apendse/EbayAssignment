package com.aap.compose.ebay.intvw.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.aap.compose.ebay.intvw.navigation.NavigationDestinations.MEME_INDEX
import com.aap.compose.ebay.intvw.screens.detail.EarthquakeDetail
import com.aap.compose.ebay.intvw.screens.earthquake.EqList

@Composable
fun NavigationGraph(modifier: Modifier, navController: NavHostController) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavigationDestinations.HOME
    ) {
        composable(NavigationDestinations.HOME) {
            EqList({index -> navController.navigate("${NavigationDestinations.EARTHQUAKE_DETAILS_PREFIX}/$index")})
        }

        composable(NavigationDestinations.EARTHQUAKE_DETAILS_PATH,
            arguments =
        listOf(navArgument(NavigationDestinations.EQ_INDEX) { type = NavType.IntType})) {
            EarthquakeDetail(it.arguments?.getInt(NavigationDestinations.EQ_INDEX) ?: 0)
        }

        composable(NavigationDestinations.MEME_DETAIL,
            arguments = listOf(
                navArgument(MEME_INDEX) { type = NavType.IntType}
            )) {
            //MemeDetail(it.arguments?.getInt(MEME_INDEX) ?: -1)
        }
    }
}