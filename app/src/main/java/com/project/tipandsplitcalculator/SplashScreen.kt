package com.project.tipandsplitcalculator

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.project.tipandsplitcalculator.navigation.Main
import com.project.tipandsplitcalculator.navigation.Splash
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier,navHostController:NavHostController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navHostController.navigate(Main) {
            popUpTo<Splash>() {
                inclusive = true
            }
        }
    }
    Image(painter = painterResource(R.drawable.logo), contentDescription = "logo", contentScale = ContentScale.Inside)
}