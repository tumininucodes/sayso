package com.rivinsurance.riv.presentation.ui.base.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rivinsurance.riv.presentation.ui.home.HomeScreen
import com.rivinsurance.riv.presentation.ui.profile.ProfileScreen
import com.tumininu.sayso.ui.base.BottomNavItem

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(BottomNavItem.Home.screenRoute) {
            HomeScreen()
        }
        composable(BottomNavItem.Wallet.screenRoute) {
        }
        composable(BottomNavItem.Profile.screenRoute) {
            ProfileScreen()
        }
    }
}