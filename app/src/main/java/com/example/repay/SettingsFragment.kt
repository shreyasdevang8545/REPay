package com.example.repay

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repay.adapters.AdapterSettings
import com.example.repay.dataClass.SettingsDataClass
import com.example.repay.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {
    private var mainBinding:FragmentSettingsBinding?=null
    private val binding get() = mainBinding
    private var adapter:AdapterSettings?=null
    private var settingList:List<SettingsDataClass> = emptyList()
    private var recyclerView: RecyclerView?=null

    @SuppressLint("CommitTransaction")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainBinding = FragmentSettingsBinding.bind(view)
        val emptyList = mutableListOf<SettingsDataClass>()

        val transaction = requireActivity().supportFragmentManager.beginTransaction()

        val toolbarTitle = requireActivity().findViewById<TextView>(R.id.toolbarTitle)
        val toolbarSetting = requireActivity().findViewById<ImageView>(R.id.settingsBtn)
        toolbarTitle.setText(R.string.settings)
        toolbarSetting.visibility = View.GONE

        emptyList.add(SettingsDataClass(R.drawable.account_settings_icon, "Account Settings", "Modify bank account, view profile information"))
        emptyList.add(SettingsDataClass(R.drawable.help_icon, "Help", "Get in touch for support and quries"))
        emptyList.add(SettingsDataClass(R.drawable.delink_icon, "De-link", "De-Link RE-Pay"))
        emptyList.add(SettingsDataClass(R.drawable.logout_icon, "Logout", "Logout from RE-Pay on this device"))

        settingList = emptyList
        recyclerView = binding?.recyclerViewSettings
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterSettings(settingList, transaction)
        recyclerView?.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }
}