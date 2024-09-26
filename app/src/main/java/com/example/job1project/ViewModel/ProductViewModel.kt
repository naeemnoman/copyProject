package com.example.job1project.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.job1project.ApiInstance.apiService
import com.example.job1project.ApiService
import com.example.job1project.Product
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {


    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    init {
        viewModelScope.launch{
            fetchProducts()
        }


    }

    private suspend fun fetchProducts() {
        try {
            val response = apiService.getProducts()

            _products.postValue(response)
        }catch (e: Exception){

        }
    }

}

