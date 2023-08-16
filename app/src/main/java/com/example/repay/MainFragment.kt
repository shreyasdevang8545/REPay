package com.example.repay

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.repay.baseactivity.REPayUtils
import com.example.repay.databinding.FragmentOtpRequestMainBinding
import com.example.repay.databinding.ToolbarBinding
import com.example.repay.listener.DataListener
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions

class MainFragment : AppCompatActivity(), DataListener {
    private var mainBinding: FragmentOtpRequestMainBinding?=null
    var requestOtpFragment = RequestOtpFragment()
    var myVoucherFragment = MyVoucherQrDisplay()
    var navigationDetails = NavigationDetails()
    private var auth:FirebaseAuth?=null
    var TAG:String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = FragmentOtpRequestMainBinding.inflate(layoutInflater)
        setContentView(mainBinding!!.root)
        //Toolbar section to update the title and back button
        var textview = findViewById<TextView>(R.id.toolbarTitle)
        textview.setText(R.string.app_name)

        var transactionManager = supportFragmentManager.beginTransaction()
        transactionManager.replace(R.id.fragment_container, requestOtpFragment)
        transactionManager.addToBackStack(null)
        transactionManager.commit()
    }

    override fun onDataPassed(data: String) {
        val bundle = Bundle()
        bundle.putString("mobileNumber", data)

        val transaction = this.supportFragmentManager.beginTransaction()
        val requestOtpEnterFragment = RequesOtpEnterFragment()
        requestOtpEnterFragment.arguments = bundle
        transaction.replace(R.id.fragment_container, requestOtpEnterFragment).commit()
    }
}