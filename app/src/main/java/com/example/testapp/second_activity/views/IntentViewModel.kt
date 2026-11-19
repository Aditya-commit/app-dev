package com.example.testapp.second_activity.views

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class IntentViewModel() : ViewModel(){

    private val _imageUrl = MutableStateFlow("")
    val imgUrl = _imageUrl.asStateFlow()

    fun updateImageUrl(url : String) {
        println("----------")
        println(url)
        println("----------")
        _imageUrl.value = url
    }
}