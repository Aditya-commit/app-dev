package com.example.testapp.views.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class  UsernameViewModel : ViewModel() {

    private val _usernameState = MutableStateFlow<String>("")
    val username : StateFlow<String> = _usernameState.asStateFlow()

    fun updateUsername(value : String){
        _usernameState.value = value
    }
}