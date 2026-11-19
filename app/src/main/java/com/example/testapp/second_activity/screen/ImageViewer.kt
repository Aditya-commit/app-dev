package com.example.testapp.second_activity.screen

import android.content.Context
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.testapp.second_activity.views.IntentViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ImageViewer(
    imageUrl : String,
    intentViewModel: IntentViewModel = viewModel()
){
    val intentmodel by intentViewModel.imgUrl.collectAsStateWithLifecycle()

    LaunchedEffect(imageUrl) {
        intentViewModel.updateImageUrl(imageUrl)
    }

    AsyncImage(
        model = intentmodel,
        contentDescription = "Image recived by intent",
        modifier = Modifier.size(
            width = 200.dp,
            height = 200.dp
        )
    )
}


// I HAVE USED VIEW MODEL HERE JUST TO SHOW HOW WE CAN STORE THE INTENT VALUE IN VIEW MODEL ALTHOUGH THE CLEANER AND BETTER APPRORACH WOULD HAVE BEEN SIMPLY USING THTE PARAMETER FOR IMAGE URL