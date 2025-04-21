package com.stargalaxy.spacetraveler.ui.screens.tour.page.models

sealed class TourPageViewState {
    data object Loading : TourPageViewState()
    data class Error(val description: String, val icon: Int) : TourPageViewState()
    data class Display(
        val planetName: String,
        val photo: String,
        val rating: Int,
        val type: String,
        val description: String
    ) : TourPageViewState()
}