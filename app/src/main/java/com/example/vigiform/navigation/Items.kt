package com.example.vigiform.navigation

import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.vigiform.R

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

object ItemNames {
    fun getOhmsLaw(context: Context): String { return context.getString(R.string.ohms_law) }
    fun getOhmsLaw2(context: Context): String { return context.getString(R.string.ohms_law2) }
    fun getDosage(context: Context): String { return context.getString(R.string.dosage) }
    fun getKineticEnergy(context: Context): String { return context.getString(R.string.kinetic_energy) }
    fun getKineticEnergy2(context: Context): String { return context.getString(R.string.kinetic_energy2) }
    fun getDensity(context: Context): String { return context.getString(R.string.density) }
    fun getAbout(context: Context): String { return context.getString(R.string.about) }
}

object Items {
    fun getItems(context: Context): Array<Item> {
        return arrayOf(
            Item(ItemNames.getOhmsLaw(context), false, getElectricBoltImage(context), ItemNames.getOhmsLaw2(context), Routes.OhmsLaw.route),
            Item(ItemNames.getDosage(context), false, getDogImage(context), ItemNames.getDosage(context), Routes.Dosage.route),
            Item(ItemNames.getKineticEnergy(context), false, getTestTubeDiagonalImage(context), ItemNames.getKineticEnergy2(context), Routes.KineticEnergy.route),
            Item(ItemNames.getDensity(context), false, getFlaskConical(context), ItemNames.getDensity(context), Routes.Density.route),
            Item(ItemNames.getAbout(context), false, Icons.Default.Info, ItemNames.getAbout(context), Routes.About.route)
        )
    }
}