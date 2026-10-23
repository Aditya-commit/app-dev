package com.example.testapp.posts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true , showBackground = true)
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppBottomBar(){
    BottomAppBar(
        containerColor = Color.Red,
        contentColor = Color.White,
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back"
                )
            }
        },
        floatingActionButton = {
            Icon(
                imageVector = Icons.Outlined.Add,
                contentDescription = "Add Photo"
            )
        }
    )
}