package com.example.repay

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repay.adapters.AdapterSelectSubBank
import com.example.repay.dataClass.SelectSubBankDataClass
import com.example.repay.databinding.FragmentSelectSubBankBinding

class selectSubBankFragment : Fragment(R.layout.fragment_select_sub_bank) {
    private var mainBinding:FragmentSelectSubBankBinding?=null
    private val binding get() = mainBinding
    private lateinit var adapter: AdapterSelectSubBank
    private var selectBank:List<SelectSubBankDataClass> = emptyList()
    private var emptyList= mutableListOf<SelectSubBankDataClass>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentSelectSubBankBinding.bind(view)

        var toolbarTitle = requireActivity().findViewById<TextView>(R.id.toolbarTitle)
        toolbarTitle.setText(R.string.select_account)

//        emptyList.add(SelectSubBankDataClass(SelectBankFragment.bank1.subBankDetails.bankName, SelectBankFragment.bank1.subBankDetails.bankIfdcDes, SelectBankFragment.bank1.subBankDetails.imageId))
//        //emptyList.add(selectSubBankDataClass("SBI Bank", "SBI BANK", R.drawable.sbi))
//        emptyList.add(SelectSubBankDataClass(SelectBankFragment.bank2.subBankDetails.bankName, SelectBankFragment.bank2.subBankDetails.bankIfdcDes, SelectBankFragment.bank2.subBankDetails.imageId))
        selectBank = emptyList
        var recyclerView = binding?.recyclerViewSub
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterSelectSubBank(selectBank)
        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()
    }


}