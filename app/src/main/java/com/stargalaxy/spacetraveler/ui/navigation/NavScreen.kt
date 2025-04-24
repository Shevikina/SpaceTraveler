package com.stargalaxy.spacetraveler.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavScreen {
    @Serializable
    data object Tours : NavScreen()

    @Serializable
    data class TourPage(val tourId: Int) : NavScreen()
}