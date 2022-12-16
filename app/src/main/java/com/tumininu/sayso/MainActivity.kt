package com.tumininu.sayso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.rememberNavController
import com.tumininu.sayso.ui.base.BottomNavigationBar
import com.tumininu.sayso.ui.base.BottomNavigationGraph
import com.tumininu.sayso.ui.theme.Orange
import com.tumininu.sayso.ui.theme.SaysoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaysoTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Base()
                }
            }
        }
    }
}

@Composable
fun Base() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomNavigationBar(navController = navController)
    }, floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }, backgroundColor = Orange) {
            Image(painter = painterResource(id = R.drawable.ic_play),
                contentDescription = "Now playing",
                colorFilter = ColorFilter.tint(Color.White))
        }
    }) {
        BottomNavigationGraph(navController = navController)
    }
}