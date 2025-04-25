package com.stargalaxy.spacetraveler.ui.screens.tours.models

data class TourInfo(
    val id: Int,
    val name: String,
    val type: String,
    val image: String,
    val rating: Double,
    val pageDescription: String,
    val reviewsCount: Int,
    val tourReviews: List<String> = emptyList(),
    val isNew: Boolean = false
)