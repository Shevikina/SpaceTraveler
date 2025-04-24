package com.stargalaxy.spacetraveler.ui.screens.tour.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.stargalaxy.spacetraveler.ui.screens.tour.page.models.TourPageAction
import com.stargalaxy.spacetraveler.ui.screens.tour.page.models.TourPageEvent
import com.stargalaxy.spacetraveler.ui.screens.tour.page.views.TourPageViewDisplay
import com.stargalaxy.spacetraveler.ui.screens.tours.models.TourInfo
import com.stargalaxy.spacetraveler.ui.theme.components.JetDialog

@Composable
fun TourPageScreen(navController: NavController, tourInfo: TourInfo) {
    val viewAction = remember { mutableStateOf<TourPageAction?>(null) }
    when (val action = viewAction.value) {
        is TourPageAction.ShowDialog -> {
            Dialog(onDismissRequest = { viewAction.value = null }) {
                JetDialog(
                    title = action.title,
                    body = action.body,
                    buttonText = action.buttonText,
                    onClose = { viewAction.value = null }
                )
            }
        }

        else -> {}
    }

    TourPageViewDisplay(tourInfo = tourInfo) { event ->
        when (event) {
            is TourPageEvent.CloseScreen -> {
                navController.popBackStack()
            }

            else -> {}
        }
    }
}