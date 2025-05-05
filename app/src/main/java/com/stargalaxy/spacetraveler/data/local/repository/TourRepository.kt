package com.stargalaxy.spacetraveler.data.local.repository

import com.stargalaxy.spacetraveler.data.local.entity.TourDetails
import com.stargalaxy.spacetraveler.data.local.entity.TourPreview

class TourRepository {
    private val tours = listOf(
        TourDetails(
            id = 1,
            name = "Живой огонь",
            imagePath = "file:///android_asset/App3_Image1.jpg",
            avgStars = 4.1,
            type = "Экологический туризм",
            reviews = listOf(
                "Потрясающий тур!",
                "Обязательно к посещению!"
            ),
            description = "Раз в год на плато под мировой скалой с небес сходит живой огонь.\n\nТолько самые удачливые путники видели это чудо природы!\n\nГотов ли ты стать одним из них?"
        ),
        TourDetails(
            id = 2,
            name = "Пирамиды стекла",
            imagePath = "file:///android_asset/App3_Image2.jpg",
            avgStars = 5.0,
            type = "Исторический туризм",
            reviews = emptyList(),
            description = ""
        ),
        TourDetails(
            id = 3,
            name = "Водный мир",
            imagePath = "file:///android_asset/App3_Image3.jpg",
            avgStars = 5.0,
            type = "Археологический туризм",
            reviews = listOf("", "", "", ""),
            description = ""
        )
    )

    fun getTours(): List<TourPreview> = tours.map {
        TourPreview(
            it.id,
            it.name,
            it.imagePath,
            it.avgStars,
            it.type,
            it.reviews.count(),
            ""
        )
    }

    fun getTourPage(id: Int): TourDetails = tours.first { it.id == id }
}