package com.example.testapp.alert_dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun Alert() {

    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        FilledTonalButton(
            onClick = { showDialog=true },
            modifier = Modifier.width(width = 140.dp),
            colors = ButtonDefaults.filledTonalButtonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(2.dp , 4.dp)
        ) {
            Text(
                text = "Delete",
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete",
                tint = Color.White,
                modifier = Modifier.size(size = 14.dp)
            )
        }

        if(showDialog){
            AlertDialog(
                icon = {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = "Delete User",
                        tint = Color.Red
                    )
                },
                title = { Text(text = "Remove User") },
                text = { Text(text="Deleting this user will permanenty delete from your subscription")},
                onDismissRequest = { showDialog=false },
                dismissButton = {ConfirmBtn(text = "Cancel") { showDialog=false }},
                confirmButton = {ConfirmBtn(text = "Confirm" , onClick = { showDialog = false })}
            )
        }
    }
}


@Composable
fun ConfirmBtn(text : String , onClick : ()-> Unit){
    TextButton(onClick = onClick) {
        Text(text = text)
    }
}


// Use Dialog Composable if you want full control