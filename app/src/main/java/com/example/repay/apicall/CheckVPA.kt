package com.example.repay.apicall

import com.example.repay.apiInstance.ApiInterfaces
import com.example.repay.apiInstance.RetrofitInstance
import com.example.repay.baseactivity.REPayLogs
import com.example.repay.dataClass.CheckVPADataClass
import retrofit2.Call
import retrofit2.Response

class CheckVPA {
    fun checkVPA(checkVPADataClass: CheckVPADataClass) {
        val retrofit = RetrofitInstance.buildService(ApiInterfaces::class.java)

        retrofit.checkVPA(checkVPADataClass).enqueue(object : retrofit2.Callback<MutableList<CheckVPADataClass>>{
            override fun onResponse(call: Call<MutableList<CheckVPADataClass>>, response: Response<MutableList<CheckVPADataClass>>) {
                if (response.isSuccessful && response.body()!=null){
                    REPayLogs().error("checkVPA", response.body().toString())
                }
            }

            override fun onFailure(call: Call<MutableList<CheckVPADataClass>>, t: Throwable) {
                REPayLogs().error("checkVPA", t.localizedMessage)
            }

        })

        }
}