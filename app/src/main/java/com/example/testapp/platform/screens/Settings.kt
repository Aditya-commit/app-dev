package com.example.testapp.platform.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.SecondActivity
import java.net.URI

@Composable
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
fun SettingsScreen(){
    val context : Context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        TopAppBar(
            title = { Text("Settings") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black,
                titleContentColor = Color.LightGray
            )
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    val intent = Intent(context , SecondActivity::class.java).apply {
                        data = Uri.parse("https://picsum.photos/200/300")
                    } // EXPLICIT INTENT
                    try{
                        context.startActivity(intent)
                    }
                    catch (e : Exception){
                        println("Exception occured")
                        println(e.message)
                    }
                }
            ) {
                Text(text="Customer Care")
            }
        }
    }
}

/*

INTENTS ARE OF TWO TYPES

1) EXPLICIT INTENTS - THEY ARE USED TO START A COMPONENT IN YOUR OWN APP BECUASE YOU KNOW THE CLASS NAME OR THE SERVICE YOU WANT TO START
2) IMPLICIT INTENTS - DO NOT NAME THE ACTUAL COMPONENT BECUASE YOU DON'T KNOW RATHER THAN YOU DECLARE A GENERAL ACTION TO PERFORM , WHICH ALLOWS A COMPONENT FROM ANOTHER APP TO HANDLE IT

*/