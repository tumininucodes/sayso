package com.tumininu.sayso.ui.bookmarks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookmarksView(modifier: Modifier = Modifier) {
    Column(modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {

        Text(text = "Bookmarks",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = modifier.padding(16.dp))

    }
}