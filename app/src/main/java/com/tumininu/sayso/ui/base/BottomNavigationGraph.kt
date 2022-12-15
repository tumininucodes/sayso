package com.tumininu.sayso.ui.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tumininu.sayso.ui.bookmarks.BookmarksView
import com.tumininu.sayso.ui.home.HomeView
import com.tumininu.sayso.ui.search.SearchView

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screenRoute) {
        composable(BottomNavItem.Home.screenRoute) {
            HomeView()
        }
        composable(BottomNavItem.Search.screenRoute) {
            SearchView()
        }
        composable(BottomNavItem.Bookmarks.screenRoute) {
            BookmarksView()
        }
    }
}