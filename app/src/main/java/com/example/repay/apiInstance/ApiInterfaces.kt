package com.example.repay.apiInstance

import com.example.repay.dataClass.SelectBankDataClass
import com.example.repay.dataClass.CheckVPADataClass
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterfaces {
    @GET("/hupi/bankDetail")
    fun getBankDetails():retrofit2.Call<MutableList<SelectBankDataClass>>
    @POST("/hupi/checkMeVirtualAddress")
    fun checkVPA(@Body body: CheckVPADataClass):retrofit2.Call<MutableList<CheckVPADataClass>>
    @POST("/hupi/mePayInetentReq")
    fun intentRequest(@Body body:CheckVPADataClass):retrofit2.Call<MutableList<CheckVPADataClass>>
    @POST("/hupi/transactionStatusQuery")
    fun transactionStatusEnquiry(@Body body:CheckVPADataClass):retrofit2.Call<MutableList<CheckVPADataClass>>

}