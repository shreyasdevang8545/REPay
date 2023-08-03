package com.example.repay

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.repay.databinding.ActivityVouchersCardviewBinding

class VoucherCardview : Fragment(R.layout.activity_vouchers_cardview) {
    private var mainBinding:ActivityVouchersCardviewBinding?=null
    private val binding get() = mainBinding
    private val enterAmountFragment = EnterAmountFragment()
    private val myVoucherFragment = MyVoucherFragment()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainBinding = ActivityVouchersCardviewBinding.bind(view)

        binding?.cvMyVouchers?.setOnClickListener {
            var transactionManager = requireActivity().supportFragmentManager
            var transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, myVoucherFragment )
            transaction.commit()
        }

        binding?.addVoucher?.setOnClickListener {
            var transactionManager = requireActivity().supportFragmentManager
            var transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, enterAmountFragment )
            transaction.commit()
        }
    }
}