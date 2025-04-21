package com.stargalaxy.spacetraveler.models.events

sealed class ToursEvent {
    data object EnterScreen : ToursEvent()
    data object ReloadScreen : ToursEvent()
}