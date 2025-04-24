package com.stargalaxy.spacetraveler.ui.screens.tours.models

data class TourCardInfo(
    val name: String,
    val description: String,
    val imagePath: String,
    val rating: Double,
    val reviews: Int,
    val isNew: Boolean = false,
)