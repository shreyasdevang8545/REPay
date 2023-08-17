package com.example.repay.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.repay.AccountSettingsFragment
import com.example.repay.R
import com.example.repay.RequestOtpFragment
import com.example.repay.baseactivity.REPayUtils
import com.example.repay.baseactivity.SharedPrefUtil
import com.example.repay.dataClass.SettingsDataClass
import com.example.repay.databinding.SettingsItemsBinding

class AdapterSettings(
    private var settingsList: List<SettingsDataClass>,
    private var transaction: FragmentTransaction
): RecyclerView.Adapter<SettingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        var itemView = SettingsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SettingViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return settingsList.size
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        val settings = settingsList[position]
        val recyclerViewPosition = holder.adapterPosition
        holder.bind(settings, recyclerViewPosition, transaction)
    }
}

class SettingViewHolder(private var binding:SettingsItemsBinding):ViewHolder(binding.root) {
    val accountSetting = AccountSettingsFragment()
    val otpRequest = RequestOtpFragment()

    fun bind(settings: SettingsDataClass, recyclerViewPosition: Int, transaction: FragmentTransaction) {
        var sharedPrefUtil = SharedPrefUtil(itemView.context)
            binding.settingsLogo.setImageResource(settings.imageId)
        binding.settingsName.setText(settings.settingTitle)
        binding.settingsDesc.setText(settings.settingDecs)

        binding.settingsItem.setOnClickListener {
            if (recyclerViewPosition==0){
                transaction.replace(R.id.fragment_container, accountSetting).addToBackStack(null).commit()
            }

            if (recyclerViewPosition==3){
                sharedPrefUtil.remove(REPayUtils.getDeviceId(itemView.context)!!)
                transaction.replace(R.id.fragment_container, otpRequest).addToBackStack(null).commit()
            }
        }
    }

}
