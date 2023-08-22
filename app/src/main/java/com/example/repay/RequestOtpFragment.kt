package com.example.repay

import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.r.RequesOtpEnterFragment
import com.example.repay.apicall.CheckVPA
import com.example.repay.apicall.IntentRequest
import com.example.repay.apicall.TransactionStatusEnquiry
import com.example.repay.baseactivity.REPayLogs
import com.example.repay.dataClass.CheckVPADataClass
import com.example.repay.databinding.FragmentRequestOtpBinding
import com.google.firebase.auth.FirebaseAuth
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody


class RequestOtpFragment : Fragment(R.layout.fragment_request_otp) {
    private var mainBinding: FragmentRequestOtpBinding? = null
    private val binding get() = mainBinding!!
    private val requesOtpEnterFragment = RequesOtpEnterFragment()
    private var mAuth:FirebaseAuth?=null
    private var TAG = RequestOtpFragment::class.java.simpleName


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        mainBinding = FragmentRequestOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mAuth = FirebaseAuth.getInstance()
        binding.generateOtp.isEnabled = false

        REPayLogs().error("checkVPA","Test calling")
        val policy = ThreadPolicy.Builder().permitAll().build()

        /*StrictMode.setThreadPolicy(policy)
        testMethod()*/
        CheckVPA().checkVPA(CheckVPADataClass("40907B02CE46DFBD185782FE2265B5EF492B9280E4F83D9DBFB479F6727CEC445E48AF3EC2F082CDBF405A94E28683DBCA9CAB9B8AFA88ED039704C9CA788790", "HDFC000000000881"))
        IntentRequest().intentRequest(CheckVPADataClass("E400E35074AAD602CB5C30D055DDAF2E07CBCC59B77B6E72EA5D65BB19C09453C9D81A65DF623202BD31957BA34961664C99E5171982EDB17F8A5A9ED36E2E204AAC150EA89593C723E08D69DF41914F3743063571D40B749201EE7DEA797F7E", "HDFC000000000881"))
        TransactionStatusEnquiry().transactionStatusEnquiry(CheckVPADataClass("40907B02CE46DFBD185782FE2265B5EF834E1F1F25D1C90FC9F6EC570176DFF3F4F3E5322524E780B5FD011C71AB437F","HDFC000000000881"))


        binding.editTextFieldPhonenumber.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Do nothing
            }

            override fun afterTextChanged(s: Editable?) {
                if (binding.editTextFieldPhonenumber.text.length>=10){
                    binding.generateOtp.isEnabled = true
                }
            }

        })

        binding.generateOtp.setOnClickListener {
            var mobileNumber = binding.editTextFieldPhonenumber.text.toString()
            val transactionManager = requireActivity().supportFragmentManager
            val transaction = transactionManager.beginTransaction()
            transaction.replace(R.id.fragment_container, requesOtpEnterFragment)
            transaction.commit()
        }
    }

    fun testMethod(){
        val client = OkHttpClient()
        val mediaType = "application/json".toMediaType()
        val body = "{\"requestMsg\":\"40907B02CE46DFBD185782FE2265B5EF492B9280E4F83D9DBFB479F6727CEC445E48AF3EC2F082CDBF405A94E28683DBCA9CAB9B8AFA88ED039704C9CA788790\",\r\n\"pgMerchantId\":\"HDFC000000000881\"}".toRequestBody(mediaType)
        REPayLogs().error("checkVPA","Test method entering")
        val request = Request.Builder()
            .url("https://testupi.mindgate.in:8443/hupi/checkMeVirtualAddress")
            .post(body)
            .addHeader("Content-Type", "application/json")
            .build()
        val response = client.newCall(request).execute()
        Log.e("Test","response from sample method :"+response)
        Log.e("Test","response from sample method :"+response.message)
        Log.e("Test","response from sample method :"+response.toString())
    }

}