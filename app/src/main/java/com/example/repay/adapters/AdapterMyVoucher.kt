package com.example.repay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.repay.R
import com.example.repay.dataClass.MyVoucherDataClass
import com.example.repay.databinding.ActivityMyvoucherItemsBinding

class AdapterMyVoucher(private var myVoucherList:List<MyVoucherDataClass>, private var itemClickListner: onItemClickListner): RecyclerView.Adapter<myVoucher>() {
    interface onItemClickListner {
        fun onItemClick(item:Int)
    }

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
        holder.itemView.setOnClickListener {
            itemClickListner.onItemClick(position)
        }
    }

}

class myVoucher(private var binding: ActivityMyvoucherItemsBinding) :ViewHolder(binding.root) {

    fun bind(myVoucher: MyVoucherDataClass) {
        binding.myVoucherTitle.text = myVoucher.vocherTitle
        binding.myvoucherCode.text = myVoucher.vocherCode
        binding.myVoucherDate.text = myVoucher.voucherDate
        binding.myVoucherAmount.text = myVoucher.voucherAmount
    }

}