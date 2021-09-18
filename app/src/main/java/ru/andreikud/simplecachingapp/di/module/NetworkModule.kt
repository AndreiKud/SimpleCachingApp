package ru.andreikud.simplecachingapp.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.andreikud.simplecachingapp.data.network.RestaurantApi
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .build()

    @Provides
    @Singleton
    fun provideRestaurantApi(okHttpClient: OkHttpClient): RestaurantApi = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(RestaurantApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RestaurantApi::class.java)

}