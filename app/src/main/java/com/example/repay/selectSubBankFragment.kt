package com.example.repay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repay.adapters.adapterSelectBank
import com.example.repay.adapters.adapterSelectSubBank
import com.example.repay.dataClass.selectBankDataClass
import com.example.repay.dataClass.selectSubBankDataClass
import com.example.repay.databinding.FragmentSelectBankBinding
import com.example.repay.databinding.FragmentSelectSubBankBinding

class selectSubBankFragment : Fragment(R.layout.fragment_select_sub_bank) {
    private var mainBinding:FragmentSelectSubBankBinding?=null
    private val binding get() = mainBinding
    private lateinit var adapter:adapterSelectSubBank
    private var selectBank:List<selectSubBankDataClass> = emptyList()
    private var emptyList= mutableListOf<selectSubBankDataClass>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentSelectSubBankBinding.bind(view)

        emptyList.add(selectSubBankDataClass(selectBankFragment.bank1.subBankDetails.bankName, selectBankFragment.bank1.subBankDetails.bankIfdcDes, selectBankFragment.bank1.subBankDetails.imageId))
        //emptyList.add(selectSubBankDataClass("SBI Bank", "SBI BANK", R.drawable.sbi))
        emptyList.add(selectSubBankDataClass(selectBankFragment.bank2.subBankDetails.bankName, selectBankFragment.bank2.subBankDetails.bankIfdcDes, selectBankFragment.bank2.subBankDetails.imageId))
        selectBank = emptyList
        var recyclerView = binding?.recyclerViewSub
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        adapter = adapterSelectSubBank(selectBank)
        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()
    }


}