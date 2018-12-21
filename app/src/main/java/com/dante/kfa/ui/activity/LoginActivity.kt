package com.dante.kfa.ui.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.dante.kfa.R
import com.dante.kfa.model.User
import com.dante.kfa.presenter.LoginPresenterImpl
import com.dante.kfa.view.ILoginView

class LoginActivity : BaseActivity<LoginPresenterImpl>(), ILoginView {

    override val layoutId: Int
        get() = R.layout.activity_login

    override fun initView() {
        mPresenter?.login("SiberiaDante", "994537867zcl.")
    }

    override fun initData() {
    }

    override fun initPresenter(): LoginPresenterImpl? {
        return LoginPresenterImpl(this)
    }

    override fun onLoginSuccess(user: User) {

    }

    override fun onLoginFailed(msg: String) {
    }

    override fun onRegisterSuccess(user: User) {
    }

    override fun onRegisterFailed(msg: String) {
    }

}
