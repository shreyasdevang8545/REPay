package com.example.repay

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.repay.databinding.FragmentMyVoucherQrDisplayBinding


class MyVoucherQrDisplay : Fragment(R.layout.fragment_my_voucher_qr_display) {
    private var mainBinding:FragmentMyVoucherQrDisplayBinding?=null
    private val binding get() = mainBinding
    private var navigationRouteDetails = NavigationDetails()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentMyVoucherQrDisplayBinding.bind(view)

        binding?.navigateBtn?.setOnClickListener {
            var transactionManager = requireActivity().supportFragmentManager
            var transation = transactionManager.beginTransaction()
            transation.replace(R.id.fragment_container, navigationRouteDetails)
            transation.addToBackStack(null)
            transation.commit()
        }

        binding?.downloadQr?.setOnClickListener {
            startActivity(Intent(requireContext(), NavigationRoute::class.java))
        }

    }
}