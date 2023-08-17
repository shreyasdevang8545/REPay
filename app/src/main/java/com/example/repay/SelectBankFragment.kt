package com.example.repay

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repay.adapters.AdapterSelectBank
import com.example.repay.apiInstance.ApiInterfaces
import com.example.repay.apiInstance.ApiManager
import com.example.repay.apiInstance.RetrofitInstance
import com.example.repay.apiInstance.dataResponse
import com.example.repay.baseactivity.REPayLogs
import com.example.repay.baseactivity.REPayUtils
import com.example.repay.dataClass.SelectBankDataClass
import com.example.repay.databinding.FragmentSelectBankBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SelectBankFragment : Fragment(R.layout.fragment_select_bank), AdapterSelectBank.onItemClickListner{
    private var mainBinding:FragmentSelectBankBinding?=null
    private val binding get() = mainBinding
    private lateinit var adapter:AdapterSelectBank
    private var voucherCardView = VoucherCardview()
    private var recyclerView:RecyclerView?=null

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            mainBinding = FragmentSelectBankBinding.bind(view)

            var toolbartext = requireActivity().findViewById<TextView>(R.id.toolbarTitle)
            var toolbarBackbtn = requireActivity().findViewById<ImageView>(R.id.backBtn)
            toolbartext.text = getString(R.string.select_bank)
            toolbarBackbtn.visibility = View.GONE
            getBankDetails()

            REPayLogs().error("deviceId", REPayUtils.getDeviceId(requireContext())!!)


            recyclerView = binding?.recyclerView
    }

    override fun onItemClick(item: Int) {
        super.onItemClick(item)
        val inflater = LayoutInflater.from(requireContext())
        val dialogView = inflater.inflate(R.layout.dialog_alert_layout, null)

        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)

        // Get references to the buttons in the custom dialog
        val positiveButton = dialogView.findViewById<Button>(R.id.dialog_ok)

        // Set click listeners for the buttons
        positiveButton.setOnClickListener {
            Log.e("click", "clicked")

            var transactionManager = requireActivity().supportFragmentManager
        var transaction = transactionManager.beginTransaction()
        transaction.replace(R.id.fragment_container, voucherCardView)
        transaction.addToBackStack("null")
        transaction.commit()

        }

        dialogBuilder.create().show()

    }

    private fun getBankDetails() {
            val retrofit = RetrofitInstance.buildService(ApiInterfaces::class.java)

        retrofit.getBankDetails().enqueue(object : Callback<MutableList<SelectBankDataClass>?> {

            override fun onFailure(
                call: Call<MutableList<SelectBankDataClass>?>,
                t: Throwable
            ) {
                t.localizedMessage?.let { Log.e("saveClusterInfo", it) }
            }

            override fun onResponse(
                call: Call<MutableList<SelectBankDataClass>?>,
                response: Response<MutableList<SelectBankDataClass>?>
            ) {
                if (response.isSuccessful && response.body()!=null){
                    recyclerView?.layoutManager = LinearLayoutManager(requireContext())
                    adapter = AdapterSelectBank(response.body()!!)
                    recyclerView?.adapter = adapter
                }else{
                    Log.e("saveClusterInfo", "else calling")
                }
            }
        }
        )
        }
}