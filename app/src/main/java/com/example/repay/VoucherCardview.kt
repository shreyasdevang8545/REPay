package com.example.repay

import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.repay.databinding.ActivityVouchersCardviewBinding

class VoucherCardview : Fragment(R.layout.activity_vouchers_cardview) {
    private var mainBinding:ActivityVouchersCardviewBinding?=null
    private val binding get() = mainBinding
    private val enterAmountFragment = EnterAmountFragment()
    private val myVoucherFragment = MyVoucherFragment()
    private val transactionHistoryFragment = TransactionHistoryFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = ActivityVouchersCardviewBinding.bind(view)

        var toolbarBtn = requireActivity().findViewById<ImageView>(R.id.backBtn)
        var toolbarSettingsBtn = requireActivity().findViewById<ImageView>(R.id.settingsBtn)

        toolbarBtn.visibility = View.GONE
        toolbarSettingsBtn.visibility = View.VISIBLE

        binding?.cvMyVouchers?.setOnClickListener {
            var transactionManager = requireActivity().supportFragmentManager
            var transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, myVoucherFragment )
            transaction.addToBackStack("null")
            transaction.commit()
        }

        binding?.addVoucher?.setOnClickListener {
            var transactionManager = requireActivity().supportFragmentManager
            var transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, enterAmountFragment )
            transaction.addToBackStack("null")
            transaction.commit()
        }

        binding?.cvTransactionHistory?.setOnClickListener {
            var transactionManager = requireActivity().supportFragmentManager
            var transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, transactionHistoryFragment )
            transaction.addToBackStack("null")
            transaction.commit()
        }
    }
}