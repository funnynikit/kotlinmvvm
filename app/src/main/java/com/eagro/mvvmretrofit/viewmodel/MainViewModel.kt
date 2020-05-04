package com.eagro.mvvmretrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eagro.mvvmretrofit.model.ProductFamily
import com.eagro.mvvmretrofit.repository.DataRepository


class MainViewModel(private val dataRepository: DataRepository,private val str : String) : ViewModel()
{

    val data : LiveData<List<ProductFamily>> get() = dataRepository.getData()

}
