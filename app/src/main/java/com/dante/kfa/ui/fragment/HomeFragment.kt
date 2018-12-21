package com.dante.kfa.ui.fragment

import android.util.Log
import com.dante.kfa.R
import com.dante.kfa.presenter.base.BasePersenter
import com.dante.kfa.ui.fragment.base.BaseFragment

/**
 * create date: 2018/12/21
 */
class HomeFragment : BaseFragment<BasePersenter<*>>() {
    override val layoutId: Int
        get() = R.layout.fragment_home//To change initializer of created properties use File | Settings | File Templates.

    override fun initView() {
    }

    override fun initData() {
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomeFragment","------------------------")
    }
    override fun initPresenter(): BasePersenter<*>? {
        return null
    }
}