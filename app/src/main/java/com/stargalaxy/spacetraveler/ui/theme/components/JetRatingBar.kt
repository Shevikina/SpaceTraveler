package com.stargalaxy.spacetraveler.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.microsoft.fluent.mobile.icons.R
import com.stargalaxy.spacetraveler.ui.theme.JetSpaceTravelerTheme
import com.stargalaxy.spacetraveler.ui.theme.SpaceTravelerTheme

@Composable
fun JetStar(color: Color, modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = R.drawable.ic_fluent_star_32_filled),
        tint = color,
        contentDescription = "Icon with star",
        modifier = modifier
    )
}

@Composable
fun JetRatingBar(rating: Int, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        repeat(rating) { JetStar(JetSpaceTravelerTheme.colorScheme.secondary) }
        repeat(5 - rating) { JetStar(JetSpaceTravelerTheme.colorScheme.onSurface) }
    }
}

@Preview(showBackground = true)
@Composable
private fun JetRatingBarPreview() {
    SpaceTravelerTheme {
        JetRatingBar(
            rating = 3,
            modifier = Modifier
        )
    }
}