package com.stargalaxy.spacetraveler.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stargalaxy.spacetraveler.ui.theme.JetSpaceTravelerTheme
import com.stargalaxy.spacetraveler.ui.theme.SpaceTravelerTheme

@Composable
fun JetTextButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(24.dp), // JetSpaceTravelerTheme.shapes.dialog
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(JetSpaceTravelerTheme.colorScheme.secondary.copy(0.5f), shape)
            .sizeIn(minHeight = 54.dp, minWidth = 366.dp)
            .clickable(onClick = onClick)
    ) {
        Text(
            text = text,
            style = JetSpaceTravelerTheme.typography.bodyLarge
                .copy(fontWeight = FontWeight.Medium),
            color = JetSpaceTravelerTheme.colorScheme.onSecondary
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun JetGradientButtonPreview() {
    SpaceTravelerTheme {
        JetTextButton("Send an application") {
            println("BE SEND")
        }
    }
}