package com.example.repay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.repay.databinding.FragmentEnterAmountBinding

class EnterAmountFragment : Fragment(R.layout.fragment_enter_amount) {
    private var mainBinding:FragmentEnterAmountBinding?=null
    private val binding get() = mainBinding

    private var alertDialog:AlertDialog.Builder?=null

    private val upiPinFragment = UpiPinFragment()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentEnterAmountBinding.bind(view)

        binding?.proceedBtn?.setOnClickListener {
            var transactionManager = requireActivity().supportFragmentManager
            var transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, upiPinFragment )
            transaction.commit()
        }

        binding?.amt100?.setOnClickListener {
            alertDialog = AlertDialog.Builder(requireContext())
            var dialog = alertDialog!!.setView(R.layout.fragment_payment_successful)
            dialog.create().show()
        }

        binding?.amt500?.setOnClickListener {
            alertDialog = AlertDialog.Builder(requireContext())
            var dialog = alertDialog!!.setView(R.layout.fragment_payment_failed)
            dialog.create().show()
        }
    }
}