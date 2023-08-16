package com.example.repay.baseactivity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.repay.R
import com.example.repay.listener.DataListener
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class REPayUtils:AppCompatActivity(), DataListener{
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

    fun onDataPassed(data: String, keyValue:String, fragment: Fragment) {
        val bundle = Bundle()
        bundle.putString(keyValue, data)
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
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

    override fun onDataPassed(data: String) {
        TODO("Not yet implemented")
    }
}


