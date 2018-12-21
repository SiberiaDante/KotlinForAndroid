package com.dante.kfa.net

import com.dante.kfa.model.base.BaseResult
import com.dante.kfa.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * create date: 2018/12/21
 */
interface ApiService {
    @FormUrlEncoded
    @POST("/user/login")
    fun login(@Field("username") username: String, @Field("password") password: String): Call<BaseResult<User>>

}