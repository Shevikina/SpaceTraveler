package com.stargalaxy.spacetraveler.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.stargalaxy.spacetraveler.ui.theme.SpaceTravelerTheme

@Composable
fun JetRoundImage(
    imagePath: String,
    shape: CornerBasedShape,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = imagePath,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape)
                .background(Color.Gray)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFEEF4F3)
@Composable
private fun JetRoundImagePreview() {
    SpaceTravelerTheme {
        Box(Modifier.padding(64.dp)) {
            JetRoundImage(
                imagePath = "file:///android_asset/App3_Image1.jpg",
                shape = RoundedCornerShape(64.dp), //JetSpaceTravelerTheme.shapes.large
                modifier = Modifier
                    .height(128.dp)
            )
        }
    }
}