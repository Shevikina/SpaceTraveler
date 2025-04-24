package com.stargalaxy.spacetraveler.ui.screens.tour.page.models

import com.stargalaxy.spacetraveler.ui.screens.tours.models.TourInfo

data class TourPageInfo(
    val coreInfo: TourInfo,
    val pageDescription: String,
    val tourReviews: List<String>
)
