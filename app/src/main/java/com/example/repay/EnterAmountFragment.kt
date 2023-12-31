package com.example.repay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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

        val toolbarSettings = requireActivity().findViewById<ImageView>(R.id.settingsBtn)
        toolbarSettings.visibility = View.GONE
        val toolbarTitle = requireActivity().findViewById<TextView>(R.id.toolbarTitle)
        toolbarTitle.setText(R.string.new_voucher)

        binding?.proceedBtn?.setOnClickListener {
            var transactionManager = requireActivity().supportFragmentManager
            var transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, upiPinFragment )
            transaction.commit()
        }

        binding?.amt100?.setOnClickListener {
            val amountEditField = binding!!.editTextFieldAmount
            amountEditField.setText(R.string.rs100)
        }

        binding?.amt500?.setOnClickListener {
            val amountEditField = binding!!.editTextFieldAmount
            amountEditField.setText(R.string.rs500)
        }

        binding?.amt1000?.setOnClickListener {
            val amountEditField = binding!!.editTextFieldAmount
            amountEditField.setText(R.string.rs1000)
        }

        binding?.amt2000?.setOnClickListener {
            val amountEditField = binding!!.editTextFieldAmount
            amountEditField.setText(R.string.rs2000)
        }
    }
}