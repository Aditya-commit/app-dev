package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.testapp.alert_dialog.Alert
import com.example.testapp.login.Input
import com.example.testapp.login.SocialLogins
import com.example.testapp.state.StateManagement
import com.example.testapp.ui.theme.TestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestAppTheme {
//                SocialLogins()
//                StateManagement()
                Alert()
            }
        }
    }
}