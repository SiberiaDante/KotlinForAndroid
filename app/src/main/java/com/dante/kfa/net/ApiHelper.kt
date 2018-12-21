package com.dante.kfa.net

import com.dante.kfa.BuildConfig
import com.githubly.wanandroid.net.ReadCookiesInterceptor
import com.githubly.wanandroid.net.SaveCookiesInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * create date: 2018/12/21
 */
object ApiHelper {

    val api: ApiService

    init {
        val builder = OkHttpClient.Builder()
        builder.apply {
            connectTimeout(10, TimeUnit.SECONDS)
            readTimeout(10, TimeUnit.SECONDS)
            writeTimeout(10, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
            })
            addInterceptor(ReadCookiesInterceptor())
            addInterceptor(SaveCookiesInterceptor())
        }
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("http://wanandroid.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(builder.build())
        val retrofit = retrofitBuilder.build()
        api = retrofit.create(ApiService::class.java)
    }
}