package com.stargalaxy.spacetraveler.ui.screens.tours.models

sealed class ToursEvent {
    data object EnterScreen : ToursEvent()
    data object ReloadScreen : ToursEvent()
    data class OpenTourPageScreen(val tourInfoId: Int) : ToursEvent()
}