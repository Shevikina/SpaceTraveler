package com.stargalaxy.spacetraveler.data.local.entity

data class TourPreview(
    val id: Int,
    val name: String,
    val imagePath: String,
    val avgStars: Double,
    val type: String,
    val reviews: Int,
    val status: String
)
