package com.example.repay.baseactivity

import android.content.Context
import android.content.SharedPreferences

class SharedPrefUtil(context: Context){

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(REPayConstants().FILE_NAME_SHARED_PREF, Context.MODE_PRIVATE)

    fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean? {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String, defaultValue: String): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun remove(key: String){
        sharedPreferences.edit().remove(key).apply()
    }

}
