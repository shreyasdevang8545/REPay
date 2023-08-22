package com.example.repay.apicall

import com.example.repay.apiInstance.ApiInterfaces
import com.example.repay.apiInstance.RetrofitInstance
import com.example.repay.baseactivity.REPayLogs
import com.example.repay.dataClass.CheckVPADataClass
import retrofit2.Call
import retrofit2.Response

class TransactionStatusEnquiry {
    fun transactionStatusEnquiry(status: CheckVPADataClass){
        val retrofit = RetrofitInstance.buildService(ApiInterfaces::class.java)

        retrofit.transactionStatusEnquiry(status).enqueue(object : retrofit2.Callback<MutableList<CheckVPADataClass>>{
            override fun onResponse(call: Call<MutableList<CheckVPADataClass>>, response: Response<MutableList<CheckVPADataClass>>) {
                if (response.isSuccessful && response.body()!=null){
                    REPayLogs().error("TransactionStatusEnquiry", response.body().toString())
                }
            }

            override fun onFailure(call: Call<MutableList<CheckVPADataClass>>, t: Throwable) {
                REPayLogs().error("TransactionStatusEnquiry", t.localizedMessage)
            }

        })
    }
}