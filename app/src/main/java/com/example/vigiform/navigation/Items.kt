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
        Item("Ley Ohm", false, Electric_bolt, "LeyOhm", Routes.LeyOhm.route),
        Item("Ensilar", false, Dog, "Ensilar", Routes.Ensilar.route),
        Item("Energia Cinetica", false, TestTubeDiagonal, "EnergiaCinetica", Routes.EnergiaCinetica.route),
        Item("Densidad", false, FlaskConical, "Densidad", Routes.Densidad.route),
        Item("Acerca de", false, Icons.Default.Info, "Densidad", Routes.AcercaDe.route)
    )
}



