package com.example.repay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.repay.dataClass.SelectSubBankDataClass
import com.example.repay.databinding.ActivitySelectsubbankItemsBinding

class AdapterSelectSubBank(private var selectSubBankList: List<SelectSubBankDataClass>): RecyclerView.Adapter<selectSubBankViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): selectSubBankViewHolder {
        var itemView = ActivitySelectsubbankItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return selectSubBankViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: selectSubBankViewHolder, position: Int) {
        val selectBank = selectSubBankList[position]
        holder.bind(selectBank)
    }

    override fun getItemCount(): Int {
        return selectSubBankList.size
    }
}

class selectSubBankViewHolder(private var binding: ActivitySelectsubbankItemsBinding): ViewHolder(binding.root) {
    fun bind(selectBank: SelectSubBankDataClass) {
        binding.bankTitleSub.text = selectBank.bankName
        binding.bankDescriptionSub.text = selectBank.bankIfdcDes
        binding.imageViewItem.setImageResource(selectBank.imageId)
    }

}
