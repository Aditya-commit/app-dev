package com.example.testapp

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.testapp.login.SocialLogins
import kotlinx.serialization.Serializable

@Serializable
data object LoginScreenKey : NavKey

@Serializable
data class HomeScreenKey(val name : String) : NavKey

@Composable
fun AppNavigation(){
    val backStack = rememberNavBackStack(LoginScreenKey)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<LoginScreenKey>{
                SocialLogins {name ->
                    backStack.clear()
                    backStack.add(HomeScreenKey(name))
                }
            }
            entry<HomeScreenKey>{
                key -> HomeScreen(name=key.name)
            }
        }
    )
}