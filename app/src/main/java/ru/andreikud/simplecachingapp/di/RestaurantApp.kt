package ru.andreikud.simplecachingapp.di

import android.app.Application

class RestaurantApp : Application() {

    val appComponent: AppComponent by lazy(LazyThreadSafetyMode.NONE) {
        DaggerAppComponent.factory().create(applicationContext)
    }

}