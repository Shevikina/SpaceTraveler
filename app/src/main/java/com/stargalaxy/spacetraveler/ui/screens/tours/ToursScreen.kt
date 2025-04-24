package com.stargalaxy.spacetraveler.ui.screens.tours

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.stargalaxy.spacetraveler.ui.navigation.NavScreen
import com.stargalaxy.spacetraveler.ui.screens.tours.models.ToursAction
import com.stargalaxy.spacetraveler.ui.screens.tours.models.ToursEvent
import com.stargalaxy.spacetraveler.ui.screens.tours.views.ToursViewDisplay
import com.stargalaxy.spacetraveler.ui.theme.SpaceTravelerTheme
import com.stargalaxy.spacetraveler.ui.theme.components.JetDialog

@Composable
fun ToursScreen(navController: NavController) {
    val viewAction = remember { mutableStateOf<ToursAction?>(null) }
    when (val action = viewAction.value) {
        is ToursAction.ShowDialog -> {
            Dialog(onDismissRequest = { viewAction.value = null }) {
                JetDialog(
                    title = action.title,
                    body = action.message,
                    buttonText = action.buttonText,
                    onClose = { viewAction.value = null }
                )
            }
        }

        else -> {}
    }


    ToursViewDisplay { event ->
        when (event) {
            is ToursEvent.OpenTourPageScreen -> {
                navController.navigate(NavScreen.TourPage(event.tourInfo))
            }

            else -> {}
        }
    }
}

@Preview
@Composable
private fun ToursScreenPreview() {
    SpaceTravelerTheme {}
}