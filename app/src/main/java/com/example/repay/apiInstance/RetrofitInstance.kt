package com.example.repay.apiInstance

import android.app.Service
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val client=OkHttpClient.Builder().build()
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://9c3521ac-2d87-4dff-b404-e63e030e8f26.mock.pstmn.io")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun <T> buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
}