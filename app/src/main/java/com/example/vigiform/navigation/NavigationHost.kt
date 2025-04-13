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
