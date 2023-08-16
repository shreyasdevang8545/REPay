package com.example.repay

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.repay.baseactivity.REPayUtils
import com.example.repay.databinding.FragmentUpiPinBinding

class UpiPinFragment : Fragment(R.layout.fragment_upi_pin) {
    private var mainBinding:FragmentUpiPinBinding?=null
    private val binding get() = mainBinding
    private var loading:AlertDialog?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentUpiPinBinding.bind(view)

        //loading = REPayUtils().showLoading(requireContext())

        var toolbarBtn = requireActivity().findViewById<ImageView>(R.id.backBtn)
        toolbarBtn.setImageResource(R.drawable.back_button)
        toolbarBtn.visibility = View.VISIBLE

        toolbarBtn.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding?.proceedBtn?.setOnClickListener {
            //REPayUtils().hideLoading(loading!!)
        }

        binding?.otpCode1?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Do nothing
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding!!.otpCode2.requestFocus()
                }
            }

        })
        binding?.otpCode2?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Do nothing
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding!!.otpCode3.requestFocus()
                }
            }

        })
        binding?.otpCode3?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Do nothing
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding!!.otpCode4.requestFocus()
                }
            }

        })
        binding?.otpCode4?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Do nothing
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding!!.otpCode5.requestFocus()
                }
            }

        })
        binding?.otpCode5?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Do nothing
            }

            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 1) {
                    binding!!.otpCode6.requestFocus()
                }
            }

        })
    }
}