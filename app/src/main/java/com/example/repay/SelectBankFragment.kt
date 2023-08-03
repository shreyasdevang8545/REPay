package com.example.repay

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repay.adapters.AdapterSelectBank
import com.example.repay.dataClass.SelectBankDataClass
import com.example.repay.dataClass.SelectSubBankDataClass
import com.example.repay.databinding.FragmentSelectBankBinding
import com.example.repay.databinding.ToolbarBinding

class SelectBankFragment : Fragment(R.layout.fragment_select_bank), AdapterSelectBank.onItemClickListner{
    private var mainBinding:FragmentSelectBankBinding?=null
    private var toolbar:ToolbarBinding?=null
    private val binding get() = mainBinding
    private lateinit var adapter:AdapterSelectBank
    private var selectBank:List<SelectBankDataClass> = emptyList()
    private var emptyList= mutableListOf<SelectBankDataClass>()
    private var voucherCardView = VoucherCardview()
    private var alertDialog:AlertDialog.Builder?=null

    companion object{
        lateinit var bank1:SelectBankDataClass
        lateinit var bank2:SelectBankDataClass
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            mainBinding = FragmentSelectBankBinding.bind(view)
            toolbar = ToolbarBinding.inflate(layoutInflater)

            toolbar!!.backBtn.visibility = View.GONE
            toolbar!!.toolbarTitle.text = "Select Bank"

            bank1 = SelectBankDataClass("Axis Bank", R.drawable.splashlogo, subBankDetails = (SelectSubBankDataClass("shreyas", "1233", R.drawable.sbi)))
            bank2 = SelectBankDataClass("State Bank of India", R.drawable.splashlogo, subBankDetails = (SelectSubBankDataClass("state bank", "1111", R.drawable.sbi)))
        emptyList.add(bank1)
        emptyList.add(bank2)
        emptyList.add(SelectBankDataClass("Hdfc Bank", R.drawable.splashlogo, subBankDetails = (SelectSubBankDataClass("shreyas", "1233", R.drawable.sbi))))
        emptyList.add(SelectBankDataClass("ICICI Bank", R.drawable.splashlogo, subBankDetails = (SelectSubBankDataClass("shreyas", "1233", R.drawable.sbi))))
        emptyList.add(SelectBankDataClass("Baroda Bank", R.drawable.splashlogo, subBankDetails = (SelectSubBankDataClass("shreyas", "1233", R.drawable.sbi))))
            emptyList.add(SelectBankDataClass("Baroda Bank", R.drawable.splashlogo, subBankDetails = (SelectSubBankDataClass("shreyas", "1233", R.drawable.sbi))))

            selectBank = emptyList
        var recyclerView = binding?.recyclerView
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterSelectBank(selectBank, this)
        recyclerView?.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    override fun onItemClick(item: Int) {
        super.onItemClick(item)
        val inflater = LayoutInflater.from(requireContext())
        val dialogView = inflater.inflate(R.layout.dialog_alert_layout, null)

        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)

        // Get references to the buttons in the custom dialog
        val positiveButton = dialogView.findViewById<Button>(R.id.dialog_ok)

        // Set click listeners for the buttons
        positiveButton.setOnClickListener {
            Log.e("click", "clicked")

            var transactionManager = requireActivity().supportFragmentManager
        var transaction = transactionManager.beginTransaction()
        transaction.replace(R.id.fragment_container, voucherCardView)
        transaction.addToBackStack("null")
        transaction.commit()

        }

        dialogBuilder.create().show()

    }


}