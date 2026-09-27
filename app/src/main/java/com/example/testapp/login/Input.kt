package com.example.testapp.login

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview

@Composable()
@Preview(showBackground = true , showSystemUi = true)
fun Input(){
    val textState = rememberTextFieldState("")

//    EQUAL TO REACT USEEFFECT WITH DEPENDENCY textState
    LaunchedEffect(textState) {
        snapshotFlow { textState.text }.collect { currentText ->
            println(currentText)
            // Here currentText is what we use in snapShotFlow curly braces
            // THIS WILL RUN AFTER USER HAS TYPED THE TEXT
        }
    }

    TextField(
        state = textState,
        label = { Text("Username") },
        placeholder = { Text("Enter your username") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        inputTransformation = InputTransformation {
            val currentText : String = asCharSequence().toString()

            if(currentText == "0"){
                revertAllChanges()
            }
        },
        lineLimits = TextFieldLineLimits.SingleLine
    )
}