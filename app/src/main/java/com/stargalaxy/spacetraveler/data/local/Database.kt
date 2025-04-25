package com.stargalaxy.spacetraveler.data.local

import com.stargalaxy.spacetraveler.ui.screens.tours.models.TourInfo

object Database {
    val tourList = listOf(
        TourInfo(
            id = 0,
            name = "Живой огонь",
            type = "Экологический туризм",
            image = "file:///android_asset/App3_Image1.jpg",
            rating = 4.1,
            reviewsCount = 177,
            isNew = true,
            pageDescription = "Раз в год на плато под мировой скалой с небес сходит живой огонь. Только самые удачливые путники видели это чудо природы! Готов ли ты стать одним из них?",
            tourReviews = listOf(
                "(5) Классно!",
                "(4) Мне понравилось. Было интересно и живо. Иногда даже слишком живо...",
                "(5) Кажется, я преисполнился в своем познании после этого события!",
                "(1) Кто-то ещё ведется на эту экологическую лабуду!?"
            )
        ),
        TourInfo(
            id = 1,
            name = "Пирамиды стек...",
            type = "Исторический туризм",
            image = "file:///android_asset/App3_Image2.jpg",
            rating = 5.0,
            reviewsCount = 61,
            pageDescription = ""
        ),
        TourInfo(
            id = 2,
            name = "Водный мир",
            type = "Археологический туризм",
            image = "file:///android_asset/App3_Image3.jpg",
            rating = 5.0,
            reviewsCount = 13,
            pageDescription = ""
        )
    )
}