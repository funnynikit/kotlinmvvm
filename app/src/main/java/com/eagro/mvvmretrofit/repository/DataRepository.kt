package com.eagro.mvvmretrofit.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.eagro.mvvmretrofit.model.ProductFamily
import com.eagro.mvvmretrofit.network.MyRetrofitBuilder.apiService
import kotlinx.coroutines.*
import retrofit2.HttpException

class DataRepository
{
    private val TAG = "DataRepository"
    private var mutableLiveData = MutableLiveData<List<ProductFamily>>()
    val completableJob = Job()

    private val coroutineScope = CoroutineScope(Dispatchers.IO + completableJob)

    fun getData() : MutableLiveData<List<ProductFamily>>
    {
        coroutineScope.launch {
            val request = apiService.getProducts()
            withContext(Dispatchers.Main)
            {
                try
                {
                    Log.e(TAG,"Response :"+request)
                    mutableLiveData.value = request.body()
                }
                catch (e: HttpException)
                {

                }
                catch (e: Throwable)
                {
                    // Log error //)
                }
            }
        }
        return mutableLiveData;
    }

}