package com.example.testapp.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun StateManagement() {

//    var counter by remember { mutableIntStateOf(0) }; // IN THIS THE STATE WILL RESET TO DEFAULT WHEN THEME OR ROTATION CHANGES
    var counter by rememberSaveable { mutableIntStateOf(0) } // IT PERSITS THE STATE IN PROCESS ACTIVITY CHANGES BUT DO NOT USE IT TOO MUCH

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (counter > 0) {
            Message(counter)
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(space = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { counter++ }
            ) {
                Text(text = "Increase")
            }
            VerticalDivider(
                modifier = Modifier.height(20.dp)
            )
            Button(
                onClick = { counter++ }
            ) {
                Text(text = "Decrease")
            }
        }
    }
}

@Composable
fun Message(counter: Int) {
    Text(
        text = "Total tokens : $counter"
    )
}