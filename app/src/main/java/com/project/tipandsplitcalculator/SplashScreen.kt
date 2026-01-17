package com.project.tipandsplitcalculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
    Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            contentScale = ContentScale.Inside,
            modifier = Modifier.size(100.dp)
        )
    }
}