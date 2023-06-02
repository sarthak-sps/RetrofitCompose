package com.example.retrofitcompose.home

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitcompose.domain.items.GetProductUseCase
import com.example.retrofitcompose.domain.items.ProductItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val getProductUseCase: GetProductUseCase) :
    ViewModel() {

    private val _product = MutableStateFlow(emptyList<ProductItem>())

    val product: StateFlow<List<ProductItem>> get() = _product

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            try {
                val products = getProductUseCase()
                _product.value = products
            } catch (_: Exception) {
            }
        }
    }


}