package com.siberiadante.kotlinforandroid.kotlin.demo7

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/25
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
interface InterfaceDemo7 {
    val name: String
    var gender:String
    fun voidOne()//定义一个方法,子类必须要实现该方法
    fun voidTwo() {//定义一个方法，并实现；子类可以不实现该方法
        print("接口已经实现了这个方法")
    }
}