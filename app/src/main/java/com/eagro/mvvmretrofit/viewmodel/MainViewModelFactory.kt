package com.eagro.mvvmretrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eagro.mvvmretrofit.repository.DataRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(val dataRepository : DataRepository,val str : String) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(dataRepository,str) as T
    }
}