package com.example.testapp.platform.screens

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import kotlinx.serialization.Serializable

sealed interface Routes : NavKey {
    @Serializable
    data object HomeScreen : Routes;

    @Serializable
    data object SettingsScreen : Routes;

    @Serializable
    data object NotificationScreen : Routes;
}

@Composable
fun Layout(){

    val backStack = rememberNavBackStack(Routes.HomeScreen);
    val currentRoute = backStack.lastOrNull() ?: Routes.HomeScreen

    Scaffold(
        bottomBar = {
            Navbar(currentRoute = currentRoute) {
                newRoute ->
//                if(currentScreen != url){
//                    when(url){
//                        RouteName.HOME -> backStack.add(HomeScreen)
//                        RouteName.NOTIFICATION -> backStack.add(NotificationScreen)
//                        RouteName.SETTINGS -> backStack.add(SettingsScreen)
//                    }
//                    currentScreen = url
//                }
                if(currentRoute != newRoute){
                    backStack.add(newRoute)
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            NavDisplay(
                backStack=backStack,
                onBack = {backStack.removeLastOrNull()},
                entryProvider = entryProvider {
                    entry<Routes.HomeScreen>{
                        HomeScreen()
                    }
                    entry<Routes.SettingsScreen>{
                        SettingsScreen()
                    }
                    entry<Routes.NotificationScreen>{
                        NotificationScreen()
                    }
                },
                transitionSpec = {
                    slideInHorizontally(initialOffsetX = { it }) togetherWith slideOutHorizontally(targetOffsetX = { -it })
                },
                predictivePopTransitionSpec = {
                    slideInHorizontally(initialOffsetX = { -it }) togetherWith slideOutHorizontally(targetOffsetX = { it })
                }
            )
        }
    }
}