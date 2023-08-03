package com.example.repay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.repay.databinding.FragmentOtpRequestMainBinding
import com.example.repay.databinding.ToolbarBinding

class MainActivity : AppCompatActivity() {
    private var mainBinding: FragmentOtpRequestMainBinding?=null
    private var toolbarBinding: ToolbarBinding?=null

    var requestOtpFragment = RequestOtpFragment()
    var myVoucherFragment = MyVoucherQrDisplay()
    var navigationDetails = NavigationDetails()
    var mainActivity = MainActivity()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = FragmentOtpRequestMainBinding.inflate(layoutInflater)
        toolbarBinding = ToolbarBinding.inflate(layoutInflater)
        setContentView(mainBinding!!.root)
        val transactionManager = supportFragmentManager.beginTransaction()
        transactionManager.replace(R.id.fragment_container, requestOtpFragment)
        transactionManager.commit()
    }
}