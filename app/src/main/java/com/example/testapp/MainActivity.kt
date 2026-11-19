package com.example.testapp

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.testapp.alert_dialog.Alert
import com.example.testapp.login.Input
import com.example.testapp.login.SocialLogins
import com.example.testapp.posts.PostContainer
import com.example.testapp.state.StateManagement
import com.example.testapp.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context : Context = this
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
//                SocialLogins()
//                StateManagement()
//                Alert()
                AppNavigation()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        println("Activity started")
    }

    override fun onResume() {
        super.onResume()
        println("Resuming Activity")
    }

    override fun onRestart() {
        super.onRestart()
        println("Restarting activity")
    }

    override fun onPause() {
        super.onPause()
        println("Pausing activity")
    }

    override fun onStop() {
        super.onStop()
        println("Activity stopped")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Activity is getting destroyed")
    }
}