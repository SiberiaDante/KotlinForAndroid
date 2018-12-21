package com.dante.kfa.ui.fragment

import android.content.Intent
import android.util.Log
import com.dante.kfa.R
import com.dante.kfa.presenter.base.BasePersenter
import com.dante.kfa.ui.activity.LoginActivity
import com.dante.kfa.ui.fragment.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 * create date: 2018/12/21
 */
class MineFragment : BaseFragment<BasePersenter<*>>() {
    override val layoutId: Int
        get() = R.layout.fragment_mine

    override fun initView() {

        btn_login.setOnClickListener {
            startActivity(Intent(activity, LoginActivity::class.java))
        }
    }

    override fun initData() {
    }

    override fun initPresenter(): BasePersenter<*>? {
        return null
    }

    override fun onResume() {
        super.onResume()
        Log.d("MineFragment", "------------------------")
    }
}