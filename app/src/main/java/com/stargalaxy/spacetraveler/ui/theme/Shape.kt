package com.stargalaxy.spacetraveler.ui.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.ui.unit.dp

data class JetSpaceTravelerShapes(
    val small: CornerBasedShape = ShapeDefaults.Small,
    val medium: CornerBasedShape = ShapeDefaults.Medium,
    val large: CornerBasedShape = ShapeDefaults.Large,
    val dialog: CornerBasedShape = ShapeDefaults.Small
)

val shapes = JetSpaceTravelerShapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(64.dp),
    dialog = RoundedCornerShape(24.dp)
)