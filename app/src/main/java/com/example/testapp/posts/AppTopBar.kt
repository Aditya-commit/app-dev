package com.example.testapp.posts

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true, showBackground = true)
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppTopBar() {
    TopAppBar(
        title = { Text(text = "All Posts") },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
        ),
        navigationIcon = {},
        actions = {},
    )
}