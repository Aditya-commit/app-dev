package com.example.testapp.posts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true , showBackground = true)
@Composable
fun PostContainer(){
    Scaffold(
        topBar = { AppTopBar() },
        bottomBar = { AppBottomBar() },
        containerColor = Color.Blue,
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(10.dp)
        ){
            items(100){ index ->
                Text(
                    text="This is item ${index}"
                )
            }
        }
    }
}