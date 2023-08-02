package com.example.repay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.repay.dataClass.selectBankDataClass
import com.example.repay.databinding.ActivitySelectbankItemsBinding

class adapterSelectBank(private var selectBankList: List<selectBankDataClass>, private var itemClickListner: onItemClickListner): RecyclerView.Adapter<selectBankViewHolder>() {

    interface onItemClickListner{
        fun onItemClick(item:Int){

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): selectBankViewHolder {
        var itemView = ActivitySelectbankItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return selectBankViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return selectBankList.size
    }

    override fun onBindViewHolder(holder: selectBankViewHolder, position: Int) {
        val selectBank = selectBankList[position]
        holder.bind(selectBank)
        holder.itemView.setOnClickListener {
            itemClickListner.onItemClick(position)
        }
    }

}

class selectBankViewHolder(private var binding: ActivitySelectbankItemsBinding): ViewHolder(binding.root) {
    fun bind(selectBank: selectBankDataClass) {
        binding.bankTitle.text = selectBank.bankName
        binding.imageViewItem.setImageResource(selectBank.imageUrl)
    }

}
