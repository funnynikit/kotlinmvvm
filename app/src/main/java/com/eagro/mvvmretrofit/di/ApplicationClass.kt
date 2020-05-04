package com.eagro.mvvmretrofit.di
import android.app.Application

class ApplicationClass : Application()
{
    companion object
    {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger()
    {
        graph = DaggerApplicationComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}