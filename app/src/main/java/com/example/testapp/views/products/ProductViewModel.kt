package com.example.testapp.views.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.dto.products.Product
import com.example.testapp.dto.products.ProductsList
import com.example.testapp.repository.product.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class UIState(
    val loading: Boolean = true,
    val data: List<Product> = emptyList<Product>(),
    val error: String? = null
)

class ProductViewModel(private val productRepo: ProductRepository = ProductRepository()) :
    ViewModel() {
    private val _uiState = MutableStateFlow(UIState())
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    fun loadData() {
        _uiState.update { currentState ->
            currentState.copy(
                loading = true
            )
        }
        viewModelScope.launch {
            val result = productRepo.getProducts()

            result
                .onSuccess { productsList ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            loading = false,
                            data = productsList.products,
                            error = null
                        )
                    }
                }
                .onFailure { exception ->
                    _uiState.update { currentState ->
                        currentState.copy(
                            loading = false,
                            error = exception.message
                        )
                    }
                }
        }
    }
}