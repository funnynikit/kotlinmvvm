package com.eagro.mvvmretrofit.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eagro.mvvmretrofit.R
import com.eagro.mvvmretrofit.di.ApplicationClass
import com.eagro.mvvmretrofit.repository.DataRepository
import com.eagro.mvvmretrofit.utils.SharedPreference
import com.eagro.mvvmretrofit.viewmodel.MainViewModel
import com.eagro.mvvmretrofit.viewmodel.MainViewModelFactory
import com.google.gson.Gson
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity()
{
    @Inject
    lateinit var retrofit : Retrofit

    @Inject
    lateinit var gson : Gson

    private val TAG = "MainActivity"
    private lateinit var factory: MainViewModelFactory
    lateinit var viewModel: MainViewModel
    private var dataRepository: DataRepository = DataRepository()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApplicationClass.graph.inject(this)

        val sharedPreference: SharedPreference = SharedPreference(this)
        sharedPreference.save("name", "nikit")
        val pio: String = "This is the way"
        factory = MainViewModelFactory(dataRepository, pio)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        viewModel.data.observe(this, Observer {
            Log.e(TAG, "List Value :" + it);
        })
    }
}
