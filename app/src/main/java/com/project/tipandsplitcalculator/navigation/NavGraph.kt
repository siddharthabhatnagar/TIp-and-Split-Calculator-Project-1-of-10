package com.project.tipandsplitcalculator.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.project.tipandsplitcalculator.MainScreen
import com.project.tipandsplitcalculator.SplashScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Splash) {
        composable<Splash> {
            SplashScreen(navHostController = navHostController)
        }
        composable<Main> {
            MainScreen()
        }
    }
}