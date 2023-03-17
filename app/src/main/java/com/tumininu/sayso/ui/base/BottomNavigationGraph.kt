package com.tumininu.sayso.ui.base

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tumininu.sayso.ui.bookmarks.BookmarksView
import com.tumininu.sayso.ui.home.HomeView
import com.tumininu.sayso.ui.search.SearchView

@Composable
fun BottomNavigationGraph(activity: Activity, navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(BottomNavItem.Home.screenRoute) {
            HomeView(activity = activity)
        }
        composable(BottomNavItem.Search.screenRoute) {
            SearchView()
        }
        composable(BottomNavItem.Bookmarks.screenRoute) {
            BookmarksView()
        }
    }
}