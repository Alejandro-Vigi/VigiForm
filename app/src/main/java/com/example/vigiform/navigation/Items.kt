package com.example.vigiform.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * ES: Item es una clase de datos que representa un ítem en una lista de navegación.
 * Cada ítem contiene una etiqueta, un estado de selección, un ícono, una descripción de contenido
 * (para accesibilidad) y una ruta de navegación asociada.
 *
 * EN: Item is a data class representing an item in a navigation list.
 * Each item includes a label, a selected state, an icon, a content description
 * (for accessibility), and an associated navigation route.
 */

data class Item(
    val label: String,
    val selected: Boolean,
    val icon: ImageVector,
    val contentDescription: String,
    val route: String
)

/**
 * ES: Items es un objeto que contiene una lista de ítems (tipo Item) que serán utilizados
 * en el Drawer o barra de navegación. Cada entrada representa una sección distinta de la app.
 *
 * EN: Items is an object that contains a list of items (of type Item) used
 * in the navigation drawer or menu. Each entry represents a different section of the app.
 */

object Items {
    val items = arrayOf(
        Item("Ohms Law", false, Electric_bolt, "OhmsLaw", Routes.OhmsLaw.route),
        Item("Dosage", false, Dog, "Dosage", Routes.Dosage.route),
        Item("Kinetic Energy", false, TestTubeDiagonal, "KineticEnergy", Routes.KineticEnergy.route),
        Item("Density", false, FlaskConical, "Density", Routes.Density.route),
        Item("About", false, Icons.Default.Info, "About", Routes.About.route)
    )
}