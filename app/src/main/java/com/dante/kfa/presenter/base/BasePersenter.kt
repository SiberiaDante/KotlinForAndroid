package com.dante.kfa.presenter.base

import com.dante.kfa.view.base.IBaseView

/**
 * create date: 2018/12/21
 */
abstract class BasePersenter<T : IBaseView>(view: T) {
    var mView: T? = view
    fun onDestroy() {
        mView = null
    }
}