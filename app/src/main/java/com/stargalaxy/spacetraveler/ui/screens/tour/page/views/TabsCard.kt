package com.stargalaxy.spacetraveler.ui.screens.tour.page.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stargalaxy.spacetraveler.ui.theme.JetSpaceTravelerTheme
import com.stargalaxy.spacetraveler.ui.theme.SpaceTravelerTheme
import com.stargalaxy.spacetraveler.utils.dashedBorder

@Composable
fun TabsCard(description: String, reviews: List<String>, modifier: Modifier = Modifier) {

    val cardModeState = remember { mutableStateOf(true) } // is description mode?
    val iconButtonShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)

    Box(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .width(72.dp)
                .background(
                    color = if (cardModeState.value) JetSpaceTravelerTheme.colorScheme.background else Color.Transparent,
                    shape = iconButtonShape
                )
                .border(
                    width = 2.dp,
                    color = if (cardModeState.value) Color.Transparent else JetSpaceTravelerTheme.colorScheme.background,
                    shape = iconButtonShape
                )
                .align(Alignment.TopStart)
                .clickable { cardModeState.value = true },
            contentAlignment = Alignment.TopCenter
        ) {
            Icon(
                painter = painterResource(com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_book_open_globe_24_filled),
                tint = JetSpaceTravelerTheme.colorScheme.primary.copy(0.5f),
                contentDescription = "Icon with opened book",
                modifier = Modifier.offset(y = 12.dp)
            )
        }
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .width(72.dp)
                .background(
                    color = if (!cardModeState.value) JetSpaceTravelerTheme.colorScheme.background else Color.Transparent,
                    shape = iconButtonShape
                )
                .border(
                    width = 2.dp,
                    color = if (!cardModeState.value) Color.Transparent else JetSpaceTravelerTheme.colorScheme.background,
                    shape = iconButtonShape
                )
                .align(Alignment.TopEnd)
                .clickable { cardModeState.value = false }
        ) {
            Icon(
                painter = painterResource(com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_book_star_24_filled),
                tint = JetSpaceTravelerTheme.colorScheme.primary.copy(0.5f),
                contentDescription = "Icon with opened book",
                modifier = Modifier.offset(y = 12.dp)
            )
        }
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 34.dp)
                .background(
                    color = JetSpaceTravelerTheme.colorScheme.surface,
                    shape = RoundedCornerShape(64.dp, 64.dp, 24.dp, 24.dp),
                )
                .dashedBorder(
                    2.dp,
                    color = JetSpaceTravelerTheme.colorScheme.primary.copy(0.35f),
                    shape = RoundedCornerShape(64.dp, 64.dp, 24.dp, 24.dp),
                    on = 10.dp,
                    off = 10.dp
                )
                .padding(10.dp)
                .background(
                    color = JetSpaceTravelerTheme.colorScheme.background,
                    shape = RoundedCornerShape(56.dp, 56.dp, 24.dp, 24.dp),
                )
                .padding(horizontal = 20.dp, vertical = 24.dp)
        ) {
            Text(
                text = if (cardModeState.value) description
                    .replace(".", ".\n\n")
                    .replace("!", "!\n\n")
                    .replace("?", "?\n\n")
                else reviews.reduce { a, b -> "$a\n\n$b" },
                style = JetSpaceTravelerTheme.typography.bodyLarge
                    .copy(
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                        lineHeight = 14.sp,
                        color = JetSpaceTravelerTheme.colorScheme.primary
                    )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TabsCardPreview() {
    SpaceTravelerTheme {
        Box(Modifier.padding(32.dp))
        {
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
        }
    }
}