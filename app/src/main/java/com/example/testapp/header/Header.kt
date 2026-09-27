package com.example.testapp.header
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable()
@Preview(showBackground = true , showSystemUi = true)
fun Header(){
    Text(
        text = "Welcome Back !",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )
}