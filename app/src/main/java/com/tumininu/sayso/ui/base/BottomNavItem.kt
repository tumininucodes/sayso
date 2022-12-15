package com.tumininu.sayso.ui.base

import com.tumininu.sayso.R


sealed class BottomNavItem(
    var title: String,
    var icon: Int,
    var screenRoute: String,
) {
    object Home : BottomNavItem("Home", R.drawable.ic_home, "home")
    object Search : BottomNavItem("Search", R.drawable.ic_search, "search")
    object Bookmarks : BottomNavItem("Bookmarks", R.drawable.ic_bookmark, "bookmarks")
}
