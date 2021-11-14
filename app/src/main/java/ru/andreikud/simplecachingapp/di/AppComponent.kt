package ru.andreikud.simplecachingapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.andreikud.simplecachingapp.di.module.DbModule
import ru.andreikud.simplecachingapp.di.module.NetworkModule
import ru.andreikud.simplecachingapp.ui.MainActivity
import javax.inject.Singleton

@Component(modules = [DbModule::class, NetworkModule::class])
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: MainActivity)
}