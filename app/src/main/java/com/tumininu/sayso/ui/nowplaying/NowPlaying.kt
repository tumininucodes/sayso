package com.tumininu.sayso.ui.nowplaying

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.tumininu.sayso.R
import com.tumininu.sayso.ui.theme.NotSelected
import com.tumininu.sayso.ui.theme.NowPlayingBg

@Composable
fun NowPlaying(modifier: Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .navigationBarsWithImePadding()
            .fillMaxSize()
            .background(NowPlayingBg)) {

        Spacer(modifier = modifier.height(45.dp))

        Box(modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ic_round_keyboard_arrow_down_24),
                contentDescription = "back",
                contentScale = ContentScale.FillWidth,
                modifier = modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp),
            )
            Text(text = "Now playing", modifier.align(Alignment.Center))
        }

        Spacer(modifier = modifier.height(50.dp))

        Card(
            modifier = modifier
                .padding(16.dp)
                .width(320.dp)
                .height(320.dp),
            shape = RoundedCornerShape(16.dp),
            backgroundColor = Color.White
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_headset_24),
                contentDescription = "book_art",
                modifier = modifier.padding(16.dp),
                colorFilter = ColorFilter.tint(NotSelected)
            )
        }

        Spacer(modifier = modifier.height(30.dp))

        Text(text = "Book Title", style = MaterialTheme.typography.h6)

        Text(text = "time",
            style = MaterialTheme.typography.body1)

//        Spacer(modifier = modifier.weight(1f))
    }


}