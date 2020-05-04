package com.eagro.mvvmretrofit.di

import com.eagro.mvvmretrofit.view.MainActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface ApplicationComponent {

    fun inject(activity : MainActivity)

}