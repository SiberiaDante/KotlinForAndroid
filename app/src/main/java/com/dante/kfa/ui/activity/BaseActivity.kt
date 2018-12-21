package com.dante.kfa.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dante.kfa.presenter.base.BasePersenter

/**
 * create date: 2018/12/20
 */
abstract class BaseActivity<P : BasePersenter<*>> : AppCompatActivity() {

    //kotlin 懒加载，在第一次使用Presenter时初始化，这种设计是针对一个View只针对一个Presenter。
    //多个Presenter的情况此处不应该使用泛型
    protected val mPresenter: P? by lazy { initPresenter() }
    abstract val layoutId: Int
    abstract fun initView()
    abstract fun initData()
    abstract fun initPresenter(): P?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initView()
        initData()
    }

    protected fun open(act: Activity, intent: Intent) {
        act.startActivity(intent)
    }
}