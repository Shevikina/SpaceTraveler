package com.stargalaxy.spacetraveler.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.stargalaxy.spacetraveler.local.Database
import com.stargalaxy.spacetraveler.ui.screens.tour.page.TourPageScreen
import com.stargalaxy.spacetraveler.ui.screens.tours.ToursScreen

@Composable
fun NavHostScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavScreen.Tours,
        modifier = modifier.fillMaxSize()
    ) {
        composable<NavScreen.Tours> { ToursScreen(navController) }
        composable<NavScreen.TourPage> { entry ->
            val page = entry.toRoute<NavScreen.TourPage>()
            TourPageScreen(navController, Database.tourList[page.tourId])
        }
    }
}