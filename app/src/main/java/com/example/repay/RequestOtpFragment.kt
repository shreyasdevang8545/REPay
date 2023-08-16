package com.example.repay

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.repay.databinding.FragmentRequestOtpBinding
import com.google.firebase.auth.FirebaseAuth

class RequestOtpFragment : Fragment(R.layout.fragment_request_otp) {
    private var mainBinding: FragmentRequestOtpBinding? = null
    private val binding get() = mainBinding!!
    private val requesOtpEnterFragment = RequesOtpEnterFragment()
    private var mAuth:FirebaseAuth?=null
    private var TAG = RequestOtpFragment::class.java.simpleName


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mainBinding = FragmentRequestOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
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
            var mobileNumber = binding.editTextFieldPhonenumber.text.toString()

            val transactionManager = requireActivity().supportFragmentManager
            val transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, requesOtpEnterFragment)
            transaction.commit()
        }
    }


}