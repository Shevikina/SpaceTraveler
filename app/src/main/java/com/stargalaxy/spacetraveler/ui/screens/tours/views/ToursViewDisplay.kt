package com.stargalaxy.spacetraveler.ui.screens.tours.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stargalaxy.spacetraveler.R
import com.stargalaxy.spacetraveler.data.local.Database
import com.stargalaxy.spacetraveler.ui.screens.tours.models.ToursEvent
import com.stargalaxy.spacetraveler.ui.theme.JetSpaceTravelerTheme
import com.stargalaxy.spacetraveler.ui.theme.SpaceTravelerTheme

@Composable
fun ToursViewDisplay(dispatcher: (ToursEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(JetSpaceTravelerTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.unique_offers_title),
            style = JetSpaceTravelerTheme.typography.bodyLarge.copy(
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            ),
            color = JetSpaceTravelerTheme.colorScheme.tertiary,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(16.dp))

        Database.tourList.forEach { tourInfo ->
            TourCard(
                tourInfo,
                modifier = Modifier.fillMaxWidth(),
                onClick = { dispatcher.invoke(ToursEvent.OpenTourPageScreen(tourInfo.id)) }
            )
        }

        Spacer(modifier = Modifier.width(16.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(
                    JetSpaceTravelerTheme.colorScheme.surface,
                    JetSpaceTravelerTheme.shapes.medium
                )
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description),
                style = JetSpaceTravelerTheme.typography.bodyLarge.copy(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    color = JetSpaceTravelerTheme.colorScheme.onSurface
                ),
            )
            Text(
                text = stringResource(id = R.string.company_letter)
                    .replace(". ", ".\n\n")
                    .replace(", ", ",\n"),
                style = JetSpaceTravelerTheme.typography.bodyLarge.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = JetSpaceTravelerTheme.colorScheme.onSurface,
                    lineHeight = 17.sp
                ),
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ToursViewDisplayPreview() {
    SpaceTravelerTheme {
        ToursViewDisplay {}
    }
}