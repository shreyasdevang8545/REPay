package com.example.repay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.repay.databinding.FragmentOtpRequestMainBinding
import com.example.repay.databinding.ToolbarBinding

class otpRequestMainFragment : AppCompatActivity() {
    private var mainBinding:FragmentOtpRequestMainBinding?=null
    private var toolbarBinding:ToolbarBinding?=null

    var requestOtpFragment = RequestOtpFragment()
    var myVoucherFragment = MyVoucherQrDisplay()
    var navigationDetails = NavigationDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = FragmentOtpRequestMainBinding.inflate(layoutInflater)
        toolbarBinding = ToolbarBinding.inflate(layoutInflater)
        val toolbarView = toolbarBinding!!.root
        setContentView(mainBinding!!.root)

        var transactionManager = supportFragmentManager.beginTransaction()
        transactionManager.replace(R.id.fragment_container, requestOtpFragment)
        transactionManager.commit()
    }
}