package com.example.vigiform.navigation

sealed class Routes (
    val route: String
) {
    data object OhmsLaw: Routes("ohmsLaw")
    data object KineticEnergy: Routes("kineticEnergy")
    data object Dosage: Routes("dosage")
    data object Density: Routes("density")
    data object About: Routes("about")
}
