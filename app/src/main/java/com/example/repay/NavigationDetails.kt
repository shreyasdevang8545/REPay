package com.example.repay

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repay.adapters.AdapterNavigationList
import com.example.repay.dataClass.NavigationDataClass
import com.example.repay.databinding.FragmentNavigationDetailsBinding


class NavigationDetails : Fragment(R.layout.fragment_navigation_details) {
    private var mainBinding:FragmentNavigationDetailsBinding?=null
    private val binding get() = mainBinding

    private var adapter: AdapterNavigationList?=null
    private var navigationList = emptyList<NavigationDataClass>()
    private var emptyList = mutableListOf<NavigationDataClass>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentNavigationDetailsBinding.bind(view)

        val recyclerView = binding?.recyclerViewNavigation
        if (recyclerView != null) {
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

        emptyList.add(NavigationDataClass(R.drawable.pump, "Hosadurga", "0", "0", "(12)", "Fuel", "9", "m", "Open", "Close"))
        navigationList = emptyList
        adapter = AdapterNavigationList(navigationList)
        if (recyclerView != null) {
            recyclerView.adapter = adapter
        }
    }
}