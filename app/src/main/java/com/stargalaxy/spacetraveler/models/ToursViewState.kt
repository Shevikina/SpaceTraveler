package com.stargalaxy.spacetraveler.models

sealed class ToursViewState {
    data object Loading : ToursViewState()
    data class Error(val description: String, val icon: Int) : ToursViewState()
    data class Display(val tours: List<String>) : ToursViewState()
}