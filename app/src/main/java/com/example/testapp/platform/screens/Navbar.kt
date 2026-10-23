package com.example.testapp.platform.screens

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey

data class NavItem(val label: String, val icon: ImageVector , val url : Routes);

@Composable
fun Navbar(currentRoute : NavKey , navigateTo: (newRoutes: Routes) -> Unit) {

    val navItems = listOf(
        NavItem(label = "Home", icon = Icons.Default.Home , url= Routes.HomeScreen),
        NavItem(label = "Notification", icon = Icons.Default.Notifications , url= Routes.NotificationScreen),
        NavItem(label = "Settings", icon = Icons.Default.Settings , url= Routes.SettingsScreen),
    )

    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.White,
    ) {
        navItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.url,
                onClick = { navigateTo(item.url) },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.label)
                },
                label = {
                    Text(text = item.label)
                }
            )
        }
    }
}