package com.dante.kfa.ui.fragment.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dante.kfa.presenter.base.BasePersenter

/**
 * create date: 2018/12/21
 */
abstract class BaseFragment<P : BasePersenter<*>> : Fragment() {

    abstract val layoutId: Int
    abstract fun initView()
    abstract fun initData()
    protected val mPresenter: P? by lazy { initPresenter() }
    abstract fun initPresenter(): P?


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //view和presenter解绑
        mPresenter?.onDestroy()
    }

}