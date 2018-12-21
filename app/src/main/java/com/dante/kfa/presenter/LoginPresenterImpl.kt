package com.dante.kfa.presenter

import com.dante.kfa.net.ApiCallBack
import com.dante.kfa.net.ApiHelper
import com.dante.kfa.presenter.base.BasePersenter
import com.dante.kfa.view.ILoginView

/**
 * create date: 2018/12/21
 */
class LoginPresenterImpl(view: ILoginView) : BasePersenter<ILoginView>(view), ILoginPresenter {

    override fun login(userName: String, password: String) {
        ApiHelper.api.login(userName, password).enqueue(ApiCallBack {
            if (isSuccess) {
                mView?.onLoginSuccess(data!!)
            } else {
                mView?.onRegisterFailed(errorMsg)
            }
        })
    }

    override fun register(userName: String, password: String, rePassword: String) {
    }
}