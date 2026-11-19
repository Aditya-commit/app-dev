package com.example.testapp

import android.app.usage.NetworkStatsManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.testapp.second_activity.screen.ImageViewer
import com.example.testapp.second_activity.views.IntentViewModel
import com.example.testapp.ui.theme.TestAppTheme

class SecondActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context : Context = this
        val network_manager = context.getSystemService(NETWORK_STATS_SERVICE) as NetworkStatsManager // USING CONTEXT WE CAN GET INFORMATION ABOUT THE APPLICATION OR THE ANDROID SYSTEM LIKE THIS

        val imageUrl = intent?.data?.toString() ?: ""

        setContent {
            TestAppTheme() {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ImageViewer(imageUrl)
                    Button(
                        onClick = {
                            val intent = Intent(context , MainActivity::class.java)
                            try{
                                startActivity(intent)
                            }
                            catch (e: Exception){
                                println(e.message)
                            }
                        }
                    ) {
                        Text("Back To Main Activity")
                    }
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        // RUNS IF ACTIVITY IS ALREADY OPEN
        super.onNewIntent(intent)
    }

    override fun onStart() {
        super.onStart()
        println("Activity started")
    }

    override fun onStop() {
        super.onStop()
        println("Activity stopped")
    }
}