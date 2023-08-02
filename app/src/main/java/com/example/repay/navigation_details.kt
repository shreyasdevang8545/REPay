package com.example.repay

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.repay.adapters.adapterNavigationList
import com.example.repay.dataClass.navigationDataClass
import com.example.repay.databinding.FragmentNavigationDetailsBinding


class navigation_details : Fragment(R.layout.fragment_navigation_details) {
    private var mainBinding:FragmentNavigationDetailsBinding?=null
    private val binding get() = mainBinding

    private var adapter:adapterNavigationList?=null
    private var navigationList = emptyList<navigationDataClass>()
    private var emptyList = mutableListOf<navigationDataClass>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentNavigationDetailsBinding.bind(view)

        val recyclerView = binding?.recyclerViewNavigation
        if (recyclerView != null) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

        emptyList.add(navigationDataClass(R.drawable.pump, "Hosadurga", "0", "0", "(12)", "Fuel", "9", "m", "Open", "Close"))
        navigationList = emptyList
        adapter = adapterNavigationList(navigationList)
        if (recyclerView != null) {
            recyclerView.adapter = adapter
        }
    }
}