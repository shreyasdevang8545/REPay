package com.example.repay

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.repay.baseactivity.REPayConstants
import com.example.repay.baseactivity.REPayUtils
import com.example.repay.baseactivity.SharedPrefUtil
import com.example.repay.databinding.FragmentOtpRequestMainBinding
import com.example.repay.databinding.ToolbarBinding
import com.example.repay.listener.DataListener
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions

class MainFragment : AppCompatActivity(){
    private var mainBinding: FragmentOtpRequestMainBinding?=null
    var requestOtpFragment = RequestOtpFragment()
    var voucherCard = VoucherCardview()
    var selectBank = SelectBankFragment()
    private var sharedPrefUtil:SharedPrefUtil?=null
    var TAG:String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = FragmentOtpRequestMainBinding.inflate(layoutInflater)
        setContentView(mainBinding!!.root)
        sharedPrefUtil = SharedPrefUtil(this)
        val transactionManager = supportFragmentManager.beginTransaction()

        //Toolbar section to update the title and back button
        val textview = findViewById<TextView>(R.id.toolbarTitle)
        textview.setText(R.string.app_name)

        if (sharedPrefUtil!!.getBoolean(REPayUtils.getDeviceId(this)!!, false) == true){
            transactionManager.replace(R.id.fragment_container, voucherCard)
            transactionManager.commit()
        }else{
            transactionManager.replace(R.id.fragment_container, selectBank)
            transactionManager.commit()
        }
    }
}