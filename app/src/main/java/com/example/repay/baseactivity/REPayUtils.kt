package com.example.repay.baseactivity

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.repay.R
import com.example.repay.listener.DataListener
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception

class REPayUtils{
    private var sharedPreferences:SharedPreferences?=null
    private var editor:SharedPreferences.Editor?=null

    companion object{
        @SuppressLint("HardwareIds")
        fun getDeviceId(context: Context): String? {
            return try {
                Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
            } catch (e: Exception) {
                null
            }
        }
    }
    fun getAuth(): FirebaseAuth {
        val auth:FirebaseAuth = FirebaseAuth.getInstance()
        return auth
    }

    fun isFirebaseConnected():Boolean{
        if (getAuth().currentUser!=null){
            return true
        }else{
            return false
        }
    }

    fun showLogMessage(context:Context, message:String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun showLoading(context: Context): AlertDialog {
        var alertDialog = AlertDialog.Builder(context)
            .setView(R.layout.activity_loading)
            .setCancelable(true)
            .create()
        alertDialog.show()
        return alertDialog
    }

    fun hideLoading(alertDialog: AlertDialog){
        alertDialog.dismiss()
    }
}


