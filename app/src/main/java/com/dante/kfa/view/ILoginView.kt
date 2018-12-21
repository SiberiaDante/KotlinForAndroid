package com.dante.kfa.view

import com.dante.kfa.model.User
import com.dante.kfa.view.base.IBaseView

/**
 * create date: 2018/12/21
 */
interface ILoginView : IBaseView {
    fun onLoginSuccess(user: User)
    fun onLoginFailed(msg: String)

    fun onRegisterSuccess(user: User)
    fun onRegisterFailed(msg: String)
}