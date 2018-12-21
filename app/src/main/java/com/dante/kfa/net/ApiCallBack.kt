package com.dante.kfa.net

import com.dante.kfa.App
import com.dante.kfa.model.base.BaseResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * create date: 2018/12/21
 */
class ApiCallBack<T>(val result: BaseResult<T>.()->Unit) : Callback<BaseResult<T>> {
    override fun onFailure(call: Call<BaseResult<T>>, throwable: Throwable) {
        val error = when (throwable) {
            is SocketTimeoutException -> "网络不给力！"
            is ConnectException -> "当前的网络不通！"
            is UnknownHostException -> "当前的网络不通！"
            else -> "当前服务异常！"
            //可进一步细分错误类型
        }
        BaseResult<T>().apply {
            errorCode = -1
            errorMsg = error
        }.result()
    }

    override fun onResponse(call: Call<BaseResult<T>>, response: Response<BaseResult<T>>) {
        val code =response.code()
        if (code in 200..299){
            val errorCode = response.body()?.errorCode
            if (errorCode==-1001){
                //重新登录
                App.instance.user=null
            }else{
                response.body()!!.result()
            }
        }else {
            onFailure(call, RuntimeException("response error,detail = " + response.raw().toString()))
        }
    }
}