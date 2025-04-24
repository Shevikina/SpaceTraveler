package com.stargalaxy.spacetraveler.ui.screens.tours.models

sealed class ToursAction {
    data class ShowDialog(
        val title: String,
        val message: String,
        val buttonText: String
    ) : ToursAction()
}