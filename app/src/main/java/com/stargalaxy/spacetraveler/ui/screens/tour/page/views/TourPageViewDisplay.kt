package com.stargalaxy.spacetraveler.ui.screens.tour.page.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.microsoft.fluent.mobile.icons.R
import com.stargalaxy.spacetraveler.ui.theme.JetSpaceTravelerTheme
import com.stargalaxy.spacetraveler.ui.theme.SpaceTravelerTheme
import com.stargalaxy.spacetraveler.ui.theme.components.JetIconButton
import com.stargalaxy.spacetraveler.ui.theme.components.JetRatingBar
import com.stargalaxy.spacetraveler.ui.theme.components.JetRoundImage
import com.stargalaxy.spacetraveler.ui.theme.components.JetTextButton

@Composable
fun TourPageViewDisplay() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(JetSpaceTravelerTheme.colorScheme.surface)
            .verticalScroll(rememberScrollState(0))
            .padding(32.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            JetIconButton(vectorDrawableId = R.drawable.ic_fluent_chevron_left_16_filled) {
                println(
                    "Clicked"
                )
            }
            Text(
                text = "Живой огонь",
                textAlign = TextAlign.Center,
                style = JetSpaceTravelerTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = JetSpaceTravelerTheme.colorScheme.tertiary
                ),
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_fluent_alert_24_regular),
                contentDescription = null,
                tint = JetSpaceTravelerTheme.colorScheme.secondary,
                modifier = Modifier.clickable { println("Subscribed to notifications") }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier.padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            JetRoundImage(
                imagePath = "file:///android_asset/App3_Image1.jpg",
                shape = JetSpaceTravelerTheme.shapes.large,
                modifier = Modifier
                    .height(128.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Text(
                    text = "Экологический туризм",
                    style = JetSpaceTravelerTheme.typography.bodyLarge.copy(
                        fontSize = 14.sp,
                        lineHeight = 16.41.sp,
                        fontWeight = FontWeight.Medium,
                        color = JetSpaceTravelerTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .offset(12.dp)
                )
                JetRatingBar(4, Modifier.height(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        TabsCard(
            "Раз в год на плато под мировой скалой с небес сходит живой огонь. Только самые удачливые путники видели это чудо природы! Готов ли ты стать одним из них?",
            listOf(
                "(5) Классно!",
                "(4) Мне понравилось. Было интересно и живо. Иногда даже слишком живо...",
                "(5) Кажется, я преисполнился в своем познании после этого события!",
                "(1) Кто-то ещё ведется на эту экологическую лабуду!?"
            ),
            Modifier
                .height(250.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.weight(1f))

        JetTextButton("Отправить заявку") { println("BE SEND") }
    }
}

@Preview
@Composable
fun TourPageViewDisplayPreview() {
    SpaceTravelerTheme {
        TourPageViewDisplay()
    }
}