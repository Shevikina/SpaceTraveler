package com.stargalaxy.spacetraveler.ui.screens.tours.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.stargalaxy.spacetraveler.R
import com.stargalaxy.spacetraveler.ui.theme.JetSpaceTravelerTheme
import com.stargalaxy.spacetraveler.ui.theme.SpaceTravelerTheme
import com.stargalaxy.spacetraveler.ui.theme.components.JetRatingBar

@Composable
fun TourCard(
    modifier: Modifier = Modifier,
    name: String, // tour name
    description: String, //  tour description
    imagePath: String, // path to tour image
    rating: Double, // tour rating based on reviews
    reviews: Int, // number of reviews about the tour
    isNew: Boolean = false, // is tour new?
    onClick: (() -> Unit)? = null
) {
    Box(
        modifier = modifier
            .heightIn(min = 96.dp)
            .background(
                JetSpaceTravelerTheme.colorScheme.surface,
                JetSpaceTravelerTheme.shapes.medium
            )
            .let {
                if (onClick != null) it
                    .clip(JetSpaceTravelerTheme.shapes.medium)
                    .clickable(onClick = onClick) else it
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = imagePath,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(JetSpaceTravelerTheme.shapes.medium)
                    .background(Color.Gray)
            )
            Column {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 18.sp,
                                color = JetSpaceTravelerTheme.colorScheme.tertiary
                            )
                        ) {
                            append(name)
                        }
                        withStyle(
                            SpanStyle(
                                fontSize = 13.sp,
                                color = JetSpaceTravelerTheme.colorScheme.onSurface
                            )
                        ) {
                            append("\n")
                            append(description)
                        }
                    },
                    style = JetSpaceTravelerTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TextUnit.Unspecified
                    ),
                    lineHeight = 18.sp
                )
                Spacer(modifier = Modifier.height(7.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetRatingBar(
                        rating.toInt(),
                        modifier = Modifier.height(16.dp)
                    )
                    Text(
                        text = "$rating | $reviews Отзывов",
                        color = JetSpaceTravelerTheme.colorScheme.onSurface,
                        style = JetSpaceTravelerTheme.typography.bodyLarge.copy(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
        }
        if (isNew) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(84.dp, 24.dp)
                    .background(
                        Color(0xFF56CB03),
                        RoundedCornerShape(topEnd = 14.dp, bottomStart = 8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    stringResource(id = R.string.new_button),
                    style = JetSpaceTravelerTheme.typography.bodyLarge.copy(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    ),
                    color = JetSpaceTravelerTheme.colorScheme.surface
                )
            }
        }
    }
}

@Preview
@Composable
private fun TourCardPreview() {
    SpaceTravelerTheme {
        TourCard(
            name = "Живой огонь",
            description = "Экологический туризм",
            imagePath = "file:///android_asset/App3_Image1.jpg",
            rating = 4.1,
            reviews = 177,
            isNew = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}