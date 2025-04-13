package com.example.vigiform.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vigiform.screens.AcercaDeScreen
import com.example.vigiform.screens.DensidadScreen
import com.example.vigiform.screens.EnergiaCineticaScreen
import com.example.vigiform.screens.EnsilarScreen
import com.example.vigiform.screens.LeyOhmScreen

@Composable
fun NavigationHost (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.LeyOhm.route
    ) {
        composable(Routes.LeyOhm.route) { LeyOhmScreen() }
        composable(Routes.Dosis.route) { EnsilarScreen() }
        composable(Routes.EnergiaCinetica.route) { EnergiaCineticaScreen() }
        composable(Routes.Densidad.route) { DensidadScreen() }
        composable(Routes.AcercaDe.route) { AcercaDeScreen() }
    }
}
