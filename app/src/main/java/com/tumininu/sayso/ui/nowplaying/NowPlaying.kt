package com.tumininu.sayso.ui.nowplaying

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NowPlaying(modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(32.dp)
            .fillMaxSize()
    ) {

        Text(
            text = "Book Title",
            style = MaterialTheme.typography.h6
        )

        Spacer(modifier = modifier.height(32.dp))

        Image(
            painter = painterResource(id = com.tumininu.sayso.R.drawable.sound),
            contentDescription = "book_art",
//            modifier = modifier
        )

        Text(
            text = "Click outside the bottom sheet to hide it",
            style = MaterialTheme.typography.body1
        )

//        Spacer(modifier = modifier.weight(1f))
    }
}