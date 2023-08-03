package com.example.repay

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repay.adapters.AdapterMyVoucher
import com.example.repay.dataClass.MyVoucherDataClass
import com.example.repay.databinding.FragmentMyVoucherBinding

class MyVoucherFragment : Fragment(R.layout.fragment_my_voucher) {
    private var mainBinding:FragmentMyVoucherBinding?=null
    private val binding  get() = mainBinding
    private var adapter:AdapterMyVoucher?=null
    private var myVoucherList = emptyList<MyVoucherDataClass>()
    private var emptyList = mutableListOf<MyVoucherDataClass>()
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainBinding = FragmentMyVoucherBinding.bind(view)

        emptyList.add(MyVoucherDataClass("BPCL", "Code : 123", "Valid 123", "1000"))
        myVoucherList = emptyList

        val recyclerView = binding?.recyclerViewMyVoucher
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterMyVoucher(myVoucherList)
        recyclerView?.adapter = adapter

        adapter!!.notifyDataSetChanged()

    }

}