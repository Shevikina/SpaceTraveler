package com.stargalaxy.spacetraveler.ui.screens.tour.page.models

sealed class TourPageAction {
    data class ShowDialog(
        val title: String,
        val body: String,
        val buttonText: String
    ) : TourPageAction()
}