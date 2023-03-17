package com.tumininu.sayso.ui.home

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.startActivityForResult
import com.tumininu.sayso.R
import com.tumininu.sayso.ui.theme.LightGrey
import com.tumininu.sayso.ui.theme.NotSelected
import com.tumininu.sayso.ui.theme.NowPlayingBg

@Composable
fun HomeView(activity: Activity, modifier: Modifier = Modifier) {
    Column(modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {

        Text(text = "Home",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = modifier.padding(16.dp))

        Row(modifier = modifier
            .padding(horizontal = 16.dp)
            .background(color = LightGrey, shape = RoundedCornerShape(26.dp))
            .fillMaxWidth()) {

            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "search icon",
                modifier = modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp, end = 4.dp),
                colorFilter = ColorFilter.tint(NotSelected)
            )

            Text(
                text = "Search books",
                modifier = modifier.padding(vertical = 12.dp),
                color = NotSelected,
            )
        }

        Spacer(modifier = modifier.height(10.dp))

        Card(backgroundColor = NowPlayingBg,
            modifier = modifier
                .padding(20.dp)
                .background(NowPlayingBg, shape = RoundedCornerShape(50))
                .fillMaxWidth()
                .clickable {
                    val fileIntent = Intent(
                        Intent.ACTION_OPEN_DOCUMENT
                    ).apply {
                        addCategory(Intent.CATEGORY_OPENABLE)
                        type = "*/*"
                    }
                    startActivityForResult(activity, fileIntent, 0, null)
                }) {
            Column(modifier
                .padding(20.dp)
                .fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.ic_round_add_24),
                    contentDescription = "add", modifier.align(Alignment.CenterHorizontally))
                Spacer(modifier = modifier.height(10.dp))
                Text(text = "Open a book", modifier.align(Alignment.CenterHorizontally))
            }
        }

        Text(text = "Continue Reading",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(16.dp))


        Text(text = "Downloads",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(16.dp))

        Text(text = "Documents",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(16.dp))


    }

}