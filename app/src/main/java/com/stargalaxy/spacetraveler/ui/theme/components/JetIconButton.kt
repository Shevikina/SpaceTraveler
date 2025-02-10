package com.stargalaxy.spacetraveler.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stargalaxy.spacetraveler.ui.theme.JetSpaceTravelerTheme
import com.stargalaxy.spacetraveler.ui.theme.SpaceTravelerTheme

@Composable
fun JetIconButton(
    vectorDrawableId: Int,
    modifier: Modifier = Modifier.size(48.dp),
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    contentPadding: PaddingValues = PaddingValues(12.dp),
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                Color(0xFFA5A5A5).copy(0.1f),
                shape
            )
            .padding(contentPadding)
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(id = vectorDrawableId),
            contentDescription = "Icon button",
            tint = JetSpaceTravelerTheme.colorScheme.onSurface,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun JetIconButtonPreview() {
    SpaceTravelerTheme {
        JetIconButton(
            vectorDrawableId = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_left_16_filled,
            contentPadding = PaddingValues(12.dp),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.size(48.dp)
        ) {
            println("Clicked")
        }
    }
}