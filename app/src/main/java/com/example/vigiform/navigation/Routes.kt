package com.example.vigiform.navigation

sealed class Routes (
    val route: String
) {
    data object LeyOhm: Routes("leyOhm")
    data object EnergiaCinetica: Routes("energiaCinetica")
    data object Ensilar: Routes("ensilar")
    data object Densidad: Routes("densidad")
    data object AcercaDe: Routes("acercaDe")
}
