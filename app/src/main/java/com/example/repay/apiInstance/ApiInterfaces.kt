package com.example.repay.apiInstance

import com.example.repay.dataClass.SelectBankDataClass
import retrofit2.http.GET

interface ApiInterfaces {
    @GET("/bankDetail")
    fun getBankDetails():retrofit2.Call<MutableList<SelectBankDataClass>>
}