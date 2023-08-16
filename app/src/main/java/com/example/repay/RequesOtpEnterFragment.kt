package com.example.repay

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.repay.baseactivity.REPayLogs
import com.example.repay.baseactivity.REPayUtils
import com.example.repay.databinding.FragmentEnterOtpBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import java.util.concurrent.TimeUnit

class RequesOtpEnterFragment : Fragment(R.layout.fragment_enter_otp) {
    private var mainBinding: FragmentEnterOtpBinding? = null
    private val binding get() = mainBinding!!
    private var selectBankFragment = SelectBankFragment()
    private var myVoucherFragment = VoucherCardview()
    private var oneTimePassword: String? = null
    private var auth: FirebaseAuth? = null
    private var verCode: String? = null
    private var token: ForceResendingToken? = null
    private var mobileNumber: String? = null
    private var isResend: Boolean? = null
    private var TAG = RequesOtpEnterFragment::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mainBinding = FragmentEnterOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()

        REPayLogs().error(TAG, "View Created")

        binding.otpCode1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                oneTimePassword + s
                Log.e("otp", "$s")
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding.otpCode2.requestFocus()
                }
            }

        })


        binding.otpCode2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                oneTimePassword + s
                Log.e("otp", "$s")
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding.otpCode3.requestFocus()
                }
            }

        })


        binding.otpCode3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                oneTimePassword + s
                Log.e("otp", "$s")
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding.otpCode4.requestFocus()
                }
            }

        })


        binding.otpCode4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                oneTimePassword + s
                Log.e("otp", "$s")
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding.otpCode5.requestFocus()
                }
            }

        })

        binding.otpCode5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                oneTimePassword + s
                Log.e("otp", "$s")
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding.otpCode6.requestFocus()
                }
            }

        })

        binding.otpCode6.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                oneTimePassword + s
                Log.e("otp", "$s")
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        binding.verifyBtn.setOnClickListener {
            var verificationCode = binding.otpCode1.text.toString() +
                    binding.otpCode2.text.toString() +
                    binding.otpCode3.text.toString() +
                    binding.otpCode4.text.toString() +
                    binding.otpCode5.text.toString() +
                    binding.otpCode6.text.toString()

            var credential = PhoneAuthProvider.getCredential(verCode!!, verificationCode)
            
            signIn(credential)
        }

        setotp(mobileNumber, false)
    }

    private fun signIn(credential: PhoneAuthCredential) {
        auth?.signInWithCredential(credential)?.addOnCompleteListener {task->
            if (task.isSuccessful){
                var trasaction = requireActivity().supportFragmentManager.beginTransaction()
                trasaction.replace(R.id.fragment_container, selectBankFragment)
                trasaction.commit()
            }else{
                REPayUtils().showLogMessage(requireContext(), "Invalid OTP")
            }

        }
    }

    private fun setotp(mobileNumber: String?, isResend: Boolean?) {
        val loading = REPayUtils().showLoading(requireContext())
        val phoneNumber = "+91 8861778545"  // Replace with the desired phone number
        var options = PhoneAuthOptions.newBuilder(auth!!)
            .setPhoneNumber(phoneNumber)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setActivity(requireActivity())  // Your current activity
            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onCodeSent(
                    verificationCode: String,
                    resendToken: ForceResendingToken
                ) {
                    verCode = verificationCode
                    token = resendToken
                    REPayUtils().hideLoading(loading)
                }

                override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                    REPayLogs().error(TAG, "Verification completed")
                    signInWithCredential(credential)
                }

                override fun onVerificationFailed(e: FirebaseException) {
                    REPayLogs().error(TAG, "Verification Failed")
                }
            })

        if (isResend == true){
            PhoneAuthProvider.verifyPhoneNumber(options.setForceResendingToken(token!!).build())
        }else{
            PhoneAuthProvider.verifyPhoneNumber(options.build())
        }
    }

    private fun signInWithCredential(credential: PhoneAuthCredential) {

    }
}