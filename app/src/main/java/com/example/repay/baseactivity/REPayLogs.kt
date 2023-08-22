package com.example.repay.baseactivity

import android.util.Log

class REPayLogs {
    fun error(tag:String, message: String?){
        if (message != null) {
            Log.e(tag, message)
        }
    }
}