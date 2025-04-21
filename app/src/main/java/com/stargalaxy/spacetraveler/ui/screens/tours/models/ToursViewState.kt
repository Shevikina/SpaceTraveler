package com.stargalaxy.spacetraveler.ui.screens.tours.models

sealed class ToursViewState {
    data object Loading : ToursViewState()
    data class Error(val description: String, val icon: Int) : ToursViewState()
    data class Display(val tours: List<String>) : ToursViewState()
}