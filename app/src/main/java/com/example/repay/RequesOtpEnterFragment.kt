package com.example.repay

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.repay.databinding.FragmentEnterOtpBinding

class RequesOtpEnterFragment : Fragment(R.layout.fragment_enter_otp) {
    private var mainBinding: FragmentEnterOtpBinding? = null
    private val binding get() = mainBinding!!
    private var selectBankFragment = SelectBankFragment()
    private var myVoucherFragment=VoucherCardview()
    private var oneTimePassword:String?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mainBinding = FragmentEnterOtpBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.otpCode1.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                oneTimePassword+s
                Log.e("otp", "$s")
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding.otpCode2.requestFocus()
                }
            }

        })


        binding.otpCode2.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                oneTimePassword+s
                Log.e("otp", "$s")
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding.otpCode3.requestFocus()
                }
            }

        })


        binding.otpCode3.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                oneTimePassword+s
                Log.e("otp", "$s")
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding.otpCode4.requestFocus()
                }
            }

        })


        binding.otpCode4.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                oneTimePassword+s
                Log.e("otp", "$s")
            }

            override fun afterTextChanged(s: Editable?) {
                //Do nothing
            }

        })

        binding.verifyBtn.setOnClickListener {
            var transactionManager = requireActivity().supportFragmentManager
            var transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, myVoucherFragment)
            transaction.commit()

            Log.e("otp", "$oneTimePassword")
        }

    }
}