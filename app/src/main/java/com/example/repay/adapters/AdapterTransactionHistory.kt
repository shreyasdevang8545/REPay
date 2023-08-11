package com.example.repay.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.repay.R
import com.example.repay.dataClass.TransactionHistoryDataClass
import com.example.repay.databinding.TransactionHistoryItemsBinding

class AdapterTransactionHistory(private val transactionHistoryList: List<TransactionHistoryDataClass>, private var itemClickListner: onItemClickListner): RecyclerView.Adapter<TransactionHistoryViewHolder>() {
    interface onItemClickListner {
        fun onItemClick(item:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionHistoryViewHolder {
        var itemView = TransactionHistoryItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionHistoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return transactionHistoryList.size
    }

    override fun onBindViewHolder(holder: TransactionHistoryViewHolder, position: Int) {
        val transactionHistory = transactionHistoryList[position]
        holder.bind(transactionHistory)
    }

}

class TransactionHistoryViewHolder(private var binding: TransactionHistoryItemsBinding) :ViewHolder(binding.root) {

    @SuppressLint("ResourceAsColor")
    fun bind(transactionHistory: TransactionHistoryDataClass) {
        binding.logo.setImageResource(transactionHistory.imageId)
        binding.transactionName.text = transactionHistory.transactionTitle
        binding.transactionTime.text = transactionHistory.transactionTime
        binding.transactionId.text = transactionHistory.transactionId
        binding.transactionAmt.text = transactionHistory.transactionAmount
        if (transactionHistory.transactionStatus == 0){
            binding.transactionStatus.text = "Success"
        }else{
            binding.transactionStatus.setTextColor(ContextCompat.getColor(itemView.context, R.color.red))
            binding.transactionStatus.text = "Failed"

        }
    }

}
