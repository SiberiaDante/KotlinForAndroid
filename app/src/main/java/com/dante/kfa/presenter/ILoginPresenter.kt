package com.dante.kfa.presenter

/**
 * create date: 2018/12/21
 */
interface ILoginPresenter {
    fun login(userName: String, password: String)
    fun register(userName: String, password: String, rePassword: String)
}