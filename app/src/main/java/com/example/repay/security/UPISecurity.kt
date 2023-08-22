package com.example.repay.security

import java.security.NoSuchAlgorithmException
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.SecretKeySpec


class UPISecurity
/**
 * Constructor
 */
{
    private var skeySpec: SecretKeySpec? = null
    private var cipher: Cipher? = null

    /**
     * This method is used to init encryption
     *
     * @param key
     * @throws Exception
     */
    @Throws(Exception::class)
    fun initEncrypt(key: String?) {
        try {
            skeySpec = SecretKeySpec(HexUtil().HexfromString(key!!), "AES")
            cipher = Cipher.getInstance("AES")
            cipher!!.init(1, skeySpec)
        } catch (nsae: NoSuchAlgorithmException) {
            throw Exception("Invalid Java Version")
        } catch (nse: NoSuchPaddingException) {
            throw Exception("Invalid Key")
        }
    }

    /**
     * This method is used to init decryption
     *
     * @param key
     * @throws Exception
     */
    @Throws(Exception::class)
    fun initDecrypt(key: String?) {
        try {
            skeySpec = SecretKeySpec(HexUtil().HexfromString(key!!), "AES")
            cipher = Cipher.getInstance("AES")
            cipher!!.init(2, skeySpec)
        } catch (nsae: NoSuchAlgorithmException) {
            throw Exception("Invalid Java Version")
        } catch (nse: NoSuchPaddingException) {
            throw Exception("Invalid Key")
        }
    }

    /**
     * This method is used to return encrypted data.
     *
     * @param instr
     * @return String
     * @throws Exception
     */
    @Throws(Exception::class)
    fun encrypt(message: String, enc_key: String?): String {
        return try {
            initEncrypt(enc_key)
            val encstr = cipher!!.doFinal(message.toByteArray())
            HexUtil().HextoString(encstr)
        } catch (nse: BadPaddingException) {
            throw Exception("Invalid input String")
        }
    }

    /**
     * This method is used to return decrypted data.
     *
     * @param instr
     * @return String
     * @throws Exception
     */
    @Throws(Exception::class)
    fun decrypt(message: String?, dec_key: String?): String {
        return try {
            initDecrypt(dec_key)
            val encstr = cipher!!.doFinal(HexUtil().HexfromString(message!!))
            String(encstr)
        } catch (nse: BadPaddingException) {
            throw Exception("Invalid input String")
        }
    }
}
