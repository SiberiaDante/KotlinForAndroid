package com.siberiadante.kotlinforandroid.kotlin.demop7

import com.siberiadante.kotlinforandroid.kotlin.demo7.InterfaceDemo7

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/25
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
class demo7 : InterfaceDemo7 {
    override val name: String = "SiberiaDante"
    override var gender: String = "男"

    override fun voidOne() {
    }

//    override fun voidTwo() {//接口中实现的方法，子类可以不实现
//        super.voidTwo()
//    }

    class demo : InterfaceDemo71, InterfaceDemo72 {
        override fun showName() {
        }
        override fun showAge() {//两个接口都有showAge()方法
            super<InterfaceDemo71>.showAge()//使用super.<接口名>.方法名指定使用哪个方法
            super<InterfaceDemo72>.showAge()
        }
    }
}