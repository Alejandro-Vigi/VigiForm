package com.example.vigiform.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vigiform.screens.AboutScreen
import com.example.vigiform.screens.DensityScreen
import com.example.vigiform.screens.KineticEnergyScreen
import com.example.vigiform.screens.DosageScreen
import com.example.vigiform.screens.OhmsLawScreen

/**
 * ES: NavigationHost es una función composable que define y organiza la navegación principal
 * de la aplicación utilizando Jetpack Navigation Compose. A través de un NavHost, se asigna
 * una ruta (route) a cada pantalla (screen) específica de la app. La pantalla de inicio es "OhmsLaw".
 *
 * EN: NavigationHost is a composable function that defines and manages the main navigation
 * of the app using Jetpack Navigation Compose. Through a NavHost, each screen is mapped
 * to a specific route. The starting screen is "OhmsLaw".
 */

@Composable
fun NavigationHost (
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.OhmsLaw.route
    ) {
        composable(Routes.OhmsLaw.route) { OhmsLawScreen() }
        composable(Routes.Dosage.route) { DosageScreen() }
        composable(Routes.KineticEnergy.route) { KineticEnergyScreen() }
        composable(Routes.Density.route) { DensityScreen() }
        composable(Routes.About.route) { AboutScreen() }
    }
}
