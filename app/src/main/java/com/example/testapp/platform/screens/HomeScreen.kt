package com.example.testapp.platform.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testapp.views.products.ProductViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen(
    productViewModel: ProductViewModel = viewModel()
) {
    val uiState by productViewModel.uiState.collectAsStateWithLifecycle()

    Column() {
        TopAppBar(
            title = { Text("Products") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Black,
                titleContentColor = Color.LightGray
            )
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = if (uiState.loading == true or (uiState.error is String)) Alignment.CenterHorizontally else Alignment.Start,
            verticalArrangement = if (uiState.loading == true or (uiState.error is String)) Arrangement.Center else Arrangement.Top
        ) {
            when {
                uiState.loading -> Text("Loading")
                uiState.error is String -> Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(uiState.error as String)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        FilledTonalButton(
                            onClick = { productViewModel.loadData() }
                        ) {
                            Text("Retry")
                        }
                    }
                }
                else -> LazyColumn(
                    modifier = Modifier.fillMaxSize().padding(10.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    items(items = uiState.data , key = { product -> product.id }) { product ->
                        Row(
                            modifier = Modifier
                                .background(color=Color.hsl(hue = 0.0f , saturation = 0.3f , lightness = 0.96f , alpha = 1f) , shape = RoundedCornerShape(15.dp))
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),

                        ) {
                            AsyncImage(
                                model = product.thumbnail,
                                contentDescription = product.title,
                                modifier = Modifier.size(width = 100.dp , height=100.dp)
                            )
                            Column(
                            ) {
                                Text(
                                    text = product.title,
                                    fontSize = 17.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                                Text(
                                    text = product.description,
                                    fontSize = 14.sp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}