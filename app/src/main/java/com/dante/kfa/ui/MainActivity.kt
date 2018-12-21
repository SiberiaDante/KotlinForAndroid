package com.dante.kfa.ui

import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.widget.RadioGroup
import com.dante.kfa.R
import com.dante.kfa.presenter.base.BasePersenter
import com.dante.kfa.ui.activity.BaseActivity
import com.dante.kfa.ui.adapter.HomeAdapter
import com.dante.kfa.ui.fragment.ArticleFragment
import com.dante.kfa.ui.fragment.HomeFragment
import com.dante.kfa.ui.fragment.MineFragment
import com.dante.kfa.ui.fragment.ProjectFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<BasePersenter<*>>(), RadioGroup.OnCheckedChangeListener,
    ViewPager.OnPageChangeListener {

    private val tag = "MainActivity"

    private val fragments = mutableListOf<Fragment>()
    override fun initPresenter(): BasePersenter<*>? {
        return null
    }

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView() {
        fragments.add(HomeFragment())
        fragments.add(ArticleFragment())
        fragments.add(ProjectFragment())
        fragments.add(MineFragment())
        home_view_pager.adapter = HomeAdapter(fragments, supportFragmentManager)
        home_view_pager.addOnPageChangeListener(this)
        rg_main.setOnCheckedChangeListener(this)
        home_view_pager.offscreenPageLimit = 4
        home_view_pager.currentItem = 0
    }

    override fun initData() {
    }

    override fun onCheckedChanged(radioGroup: RadioGroup?, p1: Int) {
        when(p1){
            rb_main_one.id-> home_view_pager.currentItem = 0
            rb_main_two.id-> home_view_pager.currentItem = 1
            rb_main_three.id-> home_view_pager.currentItem = 2
            rb_main_four.id-> home_view_pager.currentItem = 3
        }
//        if (p1 == rb_main_one.id) home_view_pager.currentItem = 0
//        if (p1 == rb_main_two.id) home_view_pager.currentItem = 1
//        if (p1 == rb_main_three.id) home_view_pager.currentItem = 2
//        if (p1 == rb_main_four.id) home_view_pager.currentItem = 3
    }

    override fun onPageScrollStateChanged(p0: Int) {
    }

    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
    }

    override fun onPageSelected(position: Int) {
        when(position){
            0->rb_main_one.isChecked=true
            1->rb_main_two.isChecked=true
            2->rb_main_three.isChecked=true
            3->rb_main_four.isChecked=true
        }
//        if (position == 0) rb_main_one.isChecked = true
//        if (position == 1) rb_main_two.isChecked = true
//        if (position == 2) rb_main_three.isChecked = true
//        if (position == 3) rb_main_four.isChecked = true
    }
}
