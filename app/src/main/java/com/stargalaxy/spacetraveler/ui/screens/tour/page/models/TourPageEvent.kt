package com.stargalaxy.spacetraveler.ui.screens.tour.page.models

sealed class TourPageEvent {
    data class EnterScreen(val tourId: Int) : TourPageEvent()
    data object ReloadScreen : TourPageEvent()
    data class ChangeFollowStatus(val newValue: Boolean) : TourPageEvent()
    data object BookTour : TourPageEvent()
}