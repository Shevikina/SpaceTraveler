package com.stargalaxy.spacetraveler.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.stargalaxy.spacetraveler.ui.screens.tour.page.TourPageScreen
import com.stargalaxy.spacetraveler.ui.screens.tours.ToursScreen
import com.stargalaxy.spacetraveler.ui.screens.tours.models.TourInfo

@Composable
fun NavHostScreen(modifier: Modifier = Modifier) {
    val tourList = listOf(
        TourInfo(
            name = "Живой огонь",
            type = "Экологический туризм",
            image = "file:///android_asset/App3_Image1.jpg",
            rating = 4.1,
            reviewsCount = 177,
            isNew = true,
            pageDescription = "Раз в год на плато под мировой скалой с небес сходит живой огонь. Только самые удачливые путники видели это чудо природы! Готов ли ты стать одним из них?",
            tourReviews = listOf(
                "(5) Классно!",
                "(4) Мне понравилось. Было интересно и живо. Иногда даже слишком живо...",
                "(5) Кажется, я преисполнился в своем познании после этого события!",
                "(1) Кто-то ещё ведется на эту экологическую лабуду!?"
            )
        ),
        TourInfo(
            name = "Пирамиды стек...",
            type = "Исторический туризм",
            image = "file:///android_asset/App3_Image2.jpg",
            rating = 5.0,
            reviewsCount = 61,
            pageDescription = ""
        ),
        TourInfo(
            name = "Водный мир",
            type = "Археологический туризм",
            image = "file:///android_asset/App3_Image3.jpg",
            rating = 5.0,
            reviewsCount = 13,
            pageDescription = ""
        )
    )

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavScreen.Tours,
        modifier = modifier.fillMaxSize()
    ) {
        composable<NavScreen.Tours> { ToursScreen(navController, tourList) }
        composable<NavScreen.TourPage> { entry ->
            val page = entry.toRoute<NavScreen.TourPage>()
            TourPageScreen(navController, tourList[page.tourId])
        }
    }
}