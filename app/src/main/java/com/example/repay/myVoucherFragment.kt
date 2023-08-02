package com.example.repay

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repay.adapters.adapterMyVoucher
import com.example.repay.adapters.adapterSelectBank
import com.example.repay.dataClass.myVoucherDataClass
import com.example.repay.databinding.FragmentMyVoucherBinding

class myVoucherFragment : Fragment(R.layout.fragment_my_voucher) {
    private var mainBinding:FragmentMyVoucherBinding?=null
    private val binding  get() = mainBinding
    private var adapter:adapterMyVoucher?=null
    private var myVoucherList = emptyList<myVoucherDataClass>()
    private var emptyList = mutableListOf<myVoucherDataClass>()
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainBinding = FragmentMyVoucherBinding.bind(view)

        emptyList.add(myVoucherDataClass("BPCL", "Code : 123", "Valid 123", "1000"))
        myVoucherList = emptyList

        val recyclerView = binding?.recyclerViewMyVoucher
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        adapter = adapterMyVoucher(myVoucherList)
        recyclerView?.adapter = adapter

        adapter!!.notifyDataSetChanged()

    }

}