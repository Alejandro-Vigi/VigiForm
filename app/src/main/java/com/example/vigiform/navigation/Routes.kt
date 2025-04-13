package com.example.vigiform.navigation

/**
 * ES: Routes es una clase sellada que define las rutas de navegación de la aplicación. Cada ruta
 * está representada por un objeto de tipo `Routes`, y cada uno tiene un valor de cadena que se utiliza
 * para identificar la ruta correspondiente dentro del NavHost de Jetpack Navigation Compose.
 *
 * EN: Routes is a sealed class that defines the navigation routes of the app. Each route
 * is represented by an object of type `Routes`, and each one holds a string value that is used
 * to identify the corresponding route within the Jetpack Navigation Compose NavHost.
 */

sealed class Routes (
    val route: String
) {
    data object OhmsLaw: Routes("ohmsLaw")
    data object KineticEnergy: Routes("kineticEnergy")
    data object Dosage: Routes("dosage")
    data object Density: Routes("density")
    data object About: Routes("about")
}
