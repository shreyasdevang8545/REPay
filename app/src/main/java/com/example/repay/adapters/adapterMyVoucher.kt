package com.example.repay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.repay.dataClass.myVoucherDataClass
import com.example.repay.databinding.ActivityMyvoucherItemsBinding

class adapterMyVoucher(private var myVoucherList:List<myVoucherDataClass>): RecyclerView.Adapter<myVoucher>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myVoucher {
        var itemView = ActivityMyvoucherItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return myVoucher(itemView)
    }

    override fun getItemCount(): Int {
        return myVoucherList.size
    }

    override fun onBindViewHolder(holder: myVoucher, position: Int) {
        var myVoucher = myVoucherList[position]
        holder.bind(myVoucher)
    }

}

class myVoucher(private var binding: ActivityMyvoucherItemsBinding) :ViewHolder(binding.root) {

    fun bind(myVoucher: myVoucherDataClass) {
        binding.myVoucherTitle.text = myVoucher.vocherTitle
        binding.myvoucherCode.text = myVoucher.vocherCode
        binding.myVoucherDate.text = myVoucher.voucherDate
        binding.myVoucherAmount.text = myVoucher.voucherAmount
    }

}