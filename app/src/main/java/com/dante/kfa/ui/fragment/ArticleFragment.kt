package com.dante.kfa.ui.fragment

import android.util.Log
import com.dante.kfa.R
import com.dante.kfa.presenter.base.BasePersenter
import com.dante.kfa.ui.fragment.base.BaseFragment

/**
 * create date: 2018/12/21
 */
class ArticleFragment : BaseFragment<BasePersenter<*>>() {
    override val layoutId: Int
        get() = R.layout.fragment_article

    override fun initView() {
    }

    override fun initData() {
    }

    override fun initPresenter(): BasePersenter<*>? {
        return null
    }

    override fun onResume() {
        super.onResume()
        Log.d("ArticleFragment","------------------------")
    }
}