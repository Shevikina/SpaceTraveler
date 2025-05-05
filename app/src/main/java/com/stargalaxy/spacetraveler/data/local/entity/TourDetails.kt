package com.stargalaxy.spacetraveler.data.local.entity

data class TourDetails(
    val id: Int,
    val name: String,
    val imagePath: String,
    val avgStars: Double,
    val type: String,
    val reviews: List<String>,
    val description: String
)
