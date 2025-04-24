package com.stargalaxy.spacetraveler.ui.navigation

import com.stargalaxy.spacetraveler.ui.screens.tours.models.TourInfo
import kotlinx.serialization.Serializable

@Serializable
sealed class NavScreen {
    @Serializable
    data object Tours : NavScreen()

    @Serializable
//    data class TourPage(val tourId: Int) : NavScreen()
    data class TourPage(val tourInfo: TourInfo) : NavScreen()
}