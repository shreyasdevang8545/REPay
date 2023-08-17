package com.example.repay

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repay.adapters.AdapterMyVoucher
import com.example.repay.adapters.AdapterSelectBank
import com.example.repay.dataClass.MyVoucherDataClass
import com.example.repay.databinding.FragmentMyVoucherBinding

class MyVoucherFragment : Fragment(R.layout.fragment_my_voucher), AdapterMyVoucher.onItemClickListner{
    private var mainBinding:FragmentMyVoucherBinding?=null
    private val binding  get() = mainBinding
    private var adapter:AdapterMyVoucher?=null
    private var myVoucherQrDisplay = MyVoucherQrDisplay()
    private var myVoucherList = emptyList<MyVoucherDataClass>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentMyVoucherBinding.bind(view)

        val emptyList = mutableListOf<MyVoucherDataClass>()

        emptyList.add(MyVoucherDataClass("BPCL", "Code : 123", "Valid 123", "1000"))
        myVoucherList = emptyList

        val recyclerView = binding?.recyclerViewMyVoucher
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterMyVoucher(myVoucherList, this)
        recyclerView?.adapter = adapter

        adapter!!.notifyDataSetChanged()

    }

    override fun onItemClick(item: Int) {
        var transactionManager = requireActivity().supportFragmentManager
        var transaction = transactionManager.beginTransaction()
        transaction.replace(R.id.fragment_container, myVoucherQrDisplay)
        transaction.addToBackStack("null")
        transaction.commit()
    }


}