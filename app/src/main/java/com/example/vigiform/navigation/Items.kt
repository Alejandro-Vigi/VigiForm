package com.example.vigiform.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Person
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
        Item("Ley Ohm", false, Icons.Default.Home, "LeyOhm", Routes.LeyOhm.route),
        Item("Ensilar", false, Icons.Default.Person, "Ensilar", Routes.Ensilar.route),
        Item("Energia Cinetica", false, Icons.Default.Create, "EnergiaCinetica", Routes.EnergiaCinetica.route),
        Item("Densidad", false, Icons.Default.Call, "Densidad", Routes.Densidad.route)
    )
}
