package com.dante.kfa.model.base

/**
 * create date: 2018/12/21
 */
class BaseResult<T> {
    var data: T? = null
    var errorCode: Int = -1
    var errorMsg: String = ""

    val isSuccess: Boolean
        get() = errorCode == 0
}