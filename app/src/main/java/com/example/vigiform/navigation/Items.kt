package com.example.vigiform.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

data class Item(
    val label: String,
    val selected: Boolean,
    val icon: ImageVector,
    val contentDescription: String,
    val route: String
)

object Items {
    val items = arrayOf(
        Item("Ohms Law", false, Electric_bolt, "OhmsLaw", Routes.OhmsLaw.route),
        Item("Dosage", false, Dog, "Dosage", Routes.Dosage.route),
        Item("Kinetic Energy", false, TestTubeDiagonal, "KineticEnergy", Routes.KineticEnergy.route),
        Item("Density", false, FlaskConical, "Density", Routes.Density.route),
        Item("About", false, Icons.Default.Info, "About", Routes.About.route)
    )
}



