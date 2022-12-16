package com.tumininu.sayso.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tumininu.sayso.R
import com.tumininu.sayso.ui.theme.LightGrey
import com.tumininu.sayso.ui.theme.NotSelected

@Composable
fun HomeView(modifier: Modifier = Modifier) {
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