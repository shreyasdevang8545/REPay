package com.example.repay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.repay.dataClass.navigationDataClass
import com.example.repay.databinding.ActivityNavigationItemsBinding

class adapterNavigationList(private var navigationList:List<navigationDataClass>): RecyclerView.Adapter<NavigationListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavigationListViewHolder {
        var itemView = ActivityNavigationItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NavigationListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NavigationListViewHolder, position: Int) {
        var navigation = navigationList[position]
        holder.bind(navigation)
    }

    override fun getItemCount(): Int {
        return navigationList.size
    }
}

class NavigationListViewHolder(private var binding: ActivityNavigationItemsBinding) :ViewHolder(binding.root) {
    fun bind(navigation: navigationDataClass) {
        binding.pumpImageView.setImageResource(navigation.imageId)
        binding.navigationTitle.text = navigation.pumpName
        binding.ratingNumber.text = navigation.rating
        binding.reviewNumber.text = navigation.reviews
        binding.navigationDescription.text = navigation.description
        binding.navigationDistance.text = navigation.distance
        binding.navigationDistanceType.text = navigation.distanceType
        binding.navigationStatus.text = navigation.status
        binding.navigationStatusDesc.text = navigation.statusDescription
    }
}
