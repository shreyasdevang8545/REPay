package com.example.repay

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.repay.databinding.FragmentOtpRequestMainBinding
import com.example.repay.databinding.ToolbarBinding

class MainFragment : AppCompatActivity() {
    private var mainBinding: FragmentOtpRequestMainBinding?=null
    var requestOtpFragment = RequestOtpFragment()
    var myVoucherFragment = MyVoucherQrDisplay()
    var navigationDetails = NavigationDetails()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = FragmentOtpRequestMainBinding.inflate(layoutInflater)
        setContentView(mainBinding!!.root)


        var textview = findViewById<TextView>(R.id.toolbarTitle)
        textview.setText(R.string.app_name)

        var transactionManager = supportFragmentManager.beginTransaction()
        transactionManager.replace(R.id.fragment_container, requestOtpFragment)
        transactionManager.addToBackStack(null)
        transactionManager.commit()
    }
}