package com.example.repay.apiInstance

import android.app.Service
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val client=OkHttpClient.Builder().build()
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://7395c2b0-2c0e-4d70-8557-f877bdc5025a.mock.pstmn.io")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun <T> buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
}