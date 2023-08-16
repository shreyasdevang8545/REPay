package com.example.repay

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repay.adapters.AdapterSelectBank
import com.example.repay.adapters.AdapterTransactionHistory
import com.example.repay.dataClass.TransactionHistoryDataClass
import com.example.repay.databinding.FragmentTransactionHistoryBinding

class TransactionHistoryFragment : Fragment(R.layout.fragment_transaction_history), AdapterTransactionHistory.onItemClickListner {
    private var mainBinding:FragmentTransactionHistoryBinding?=null
    private val binding get() = mainBinding
    private var adapter:AdapterTransactionHistory?=null
    private var transactionHistoryList = emptyList<TransactionHistoryDataClass>()
    private var emptyList = mutableListOf<TransactionHistoryDataClass>()
    private var myVoucherQrDisplay = MyVoucherQrDisplay()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentTransactionHistoryBinding.bind(view)

        var toolbarBtn = requireActivity().findViewById<ImageView>(R.id.backBtn)
        var toolbarTitle = requireActivity().findViewById<TextView>(R.id.toolbarTitle)
        var toolbarSettingsBtn = requireActivity().findViewById<ImageView>(R.id.settingsBtn)

        toolbarBtn.visibility = View.VISIBLE
        toolbarTitle.setText(R.string.transaction_history)
        toolbarSettingsBtn.visibility = View.GONE

        var recyclerView = binding?.transactionHistoryRecyclerview

        emptyList.add(TransactionHistoryDataClass(R.drawable.bpcl, "BPCL", "14 Jan 2023 10:15 PM", "182737373", "1000", 1))
        emptyList.add(TransactionHistoryDataClass(R.drawable.bpcl, "BPCL", "10 Aug 2023 3:15 PM", "182737454", "2000", 0))

        transactionHistoryList = emptyList
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterTransactionHistory(transactionHistoryList, this)
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