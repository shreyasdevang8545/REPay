package com.example.repay.apiInstance

import com.google.gson.annotations.SerializedName

data class dataResponse(
    @SerializedName("code")
    var statusCode:Int,

    @SerializedName("error")
    var error:Boolean,

    @SerializedName("errorMessage")
    var errorMessage:String,

    @SerializedName("data")
    var data:String
)
