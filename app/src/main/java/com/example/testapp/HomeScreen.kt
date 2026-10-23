package com.example.testapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(name: String, showAllPosts: () -> Boolean) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(5.dp), // THIS IS BASICALLY LIKE <ul className='p-[5px]'></ul> IN UL ELEMENT
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        item {
            Text(
                text = "Welcome back $name!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
        }

        stickyHeader {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "All Items",
                    fontSize = 19.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Red
                )
                TextButton(
                    onClick = { showAllPosts() },
                    modifier = Modifier.width(110.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.hsl(
                            hue = 10f,
                            saturation = 0.49f,
                            lightness = 0.39f,
                            alpha = 1f
                        ),
                    ),
                ) {
                    Text(
                        modifier = Modifier.weight(0.9f),
                        text = "All Posts",
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowRightAlt,
                        contentDescription = "View All Posts"
                    )
                }
            }
        }

        items(count = 100) { key ->
            Text(
                modifier = Modifier
                    .background(color = Color.Black)
                    .padding(30.dp),
                text = "Item $key",
                color = Color.White
            )
        }
    }
}