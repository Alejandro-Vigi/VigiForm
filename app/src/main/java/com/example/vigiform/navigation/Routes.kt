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
    /*
    ES: No lo considero como hardcoding negativo ya que estas rutas son identificadores internos utilizados por el sistema de navegación.
    * No se muestran al usuario, no cambian con el idioma, y deben ser estables para mantener la integridad de la navegación.
    * Moverlas a strings.xml no aportaría beneficios y solo complicaría el código innecesariamente. Por lo que lo dejaré así.

    EN: This is not considered bad hardcoding since these routes are internal identifiers used by the navigation system.
    * They are not user-facing, do not change based on language, and need to remain stable to ensure navigation integrity.
    * Moving them to strings.xml would add unnecessary complexity without any practical benefit.
    */

    data object OhmsLaw: Routes("ohmsLaw")
    data object KineticEnergy: Routes("kineticEnergy")
    data object Dosage: Routes("dosage")
    data object Density: Routes("density")
    data object About: Routes("about")
}
