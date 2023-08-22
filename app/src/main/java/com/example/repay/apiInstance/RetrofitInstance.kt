package com.example.repay.apiInstance

import android.app.Service
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object RetrofitInstance {
    //private val client=OkHttpClient.Builder().build()
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://testupi.mindgate.in:8443/hupi/")
            .addConverterFactory(GsonConverterFactory.create())
            .client( unSafeOkHttpClient)
            .build()
    }
    private val unSafeOkHttpClient: OkHttpClient
        get() = try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(
                object : X509TrustManager {
                    override fun checkClientTrusted(
                        chain: Array<X509Certificate>,
                        authType: String
                    ) = Unit

                    override fun checkServerTrusted(
                        chain: Array<X509Certificate>,
                        authType: String
                    ) = Unit

                    override fun getAcceptedIssuers(): Array<X509Certificate> {
                        return arrayOf()
                    }
                }
            )
            val interceptor = HttpLoggingInterceptor()
            interceptor.level =

                    HttpLoggingInterceptor.Level.BODY


            // Install the all-trusting trust manager
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())
            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory
            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { hostname: String?, session: SSLSession? -> hostname != null && session != null }
            builder.connectTimeout(30, TimeUnit.SECONDS)
            builder.readTimeout(30, TimeUnit.SECONDS)
            builder.addInterceptor(interceptor)
            builder.writeTimeout(30, TimeUnit.SECONDS)
            builder.protocols(listOf(Protocol.HTTP_1_1))
            builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }


    fun <T> buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
}