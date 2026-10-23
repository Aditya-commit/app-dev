package com.example.testapp

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.testapp.login.SocialLogins
import com.example.testapp.platform.screens.Layout
import com.example.testapp.posts.PostContainer
import kotlinx.serialization.Serializable

@Serializable
data object LoginScreenKey : NavKey

@Serializable
data object PlatformScreenKey : NavKey

//@Serializable
//data class HomeScreenKey(val name: String) : NavKey
//
//@Serializable
//data object PostScreenKey : NavKey

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(LoginScreenKey)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<LoginScreenKey> {
                SocialLogins { name ->
                    backStack.clear()
                    backStack.add(PlatformScreenKey)
                }
            }
            entry<PlatformScreenKey>{
                Layout()
            }
//            entry<HomeScreenKey> { key ->
//                HomeScreen(name = key.name) {
//                    backStack.add(PostScreenKey)
//                }
//            }
//            entry<PostScreenKey> {
//                PostContainer()
//            }
        },
        transitionSpec = {
//            slideInHorizontally(initialOffsetX = { it }) togetherWith slideOutHorizontally(
//                targetOffsetX = { -it }) // THIS WILL MAKE THE ANIMATION TO MOVE FROM RIGHT TO LEFT
            slideInVertically(
                animationSpec = tween(1000),
                initialOffsetY = { it }) togetherWith slideOutVertically(
                animationSpec = tween(1000),
                targetOffsetY = { -it })
        },
        predictivePopTransitionSpec = {
            slideInVertically(
                animationSpec = tween(1000),
                initialOffsetY = { -it }
            ) togetherWith slideOutVertically(tween(1000), { it })
        },
    )
}

//slideInVertically - { initialOffsetY {it}} 'it' is always the 100% of the height - Means the screen that has to enter (when moving forward) will enter from 100% of the height (that is bottom of the screen)
//slideOutVertically - targetOffsetY = {-it} '-it' it means that the screen to exit will start from its current position and will reach to the -100% of the height (that is upwards)
// same with horizontal {it} - Start from right , -it to the left