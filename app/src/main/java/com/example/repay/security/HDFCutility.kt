package com.example.repay.security

import android.util.Log

object HDFCutility {
    @JvmStatic
    fun main(args: Array<String>) {
        val security = UPISecurity()
        try {
            //to encrypt - params ("string to be encrypted","key as mentioned in the HDFC mail")
            val encMsg: String = security.encrypt(
                "HDFC000000000881|BOS4567|6012|P2M|PAY|TESTING|bosh@hdfcbank|Bosch|1.00|||||||||NA|NA",
                "881abcd59f68c4e25f68fc94d1db98f1"
            )
            Log.e("Security++", encMsg)

            //to decrypt - params ("string to be decrypted","key as mentioned in the HDFC mail")
            val resMsg: String = security.decrypt(
                "C21939F24CCE714EE20FE1BD2E4D4A262AA2497DD76DA15F3757DC09B023DE511DEA5568AB42167B9E242AD314E6EE43882848095F6696E94B302452C1E765219D97CBBBA072FC8E43D9FF604267B94279406B0C513B7D534338291FF60C6476CE2CC2B53C74654715344E803933D53C",
                "881abcd59f68c4e25f68fc94d1db98f1"
            )
            Log.e("Security++", resMsg)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
