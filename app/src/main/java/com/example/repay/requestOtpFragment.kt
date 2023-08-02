package com.example.repay

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.repay.databinding.FragmentRequestOtpBinding

class requestOtpFragment : Fragment(R.layout.fragment_request_otp) {
    private var mainBinding: FragmentRequestOtpBinding? = null
    private val binding get() = mainBinding!!
    private var requesOtpEnterFragment = requesOtpEnterFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mainBinding = FragmentRequestOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.generateOtp.isEnabled = false


        binding.editTextFieldPhonenumber.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Do nothing
            }

            override fun afterTextChanged(s: Editable?) {
                if (binding.editTextFieldPhonenumber.text.length>=10){
                    binding.generateOtp.isEnabled = true
                }
            }

        })

        binding.generateOtp.setOnClickListener {
            var transactionManager = requireActivity().supportFragmentManager
            var transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, requesOtpEnterFragment)
            transaction.commit()
        }
    }

}