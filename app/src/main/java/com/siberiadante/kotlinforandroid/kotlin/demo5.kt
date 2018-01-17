package com.siberiadante.kotlinforandroid.kotlin

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/16
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
//定义一个类，使用关键字class声明，后面跟类名
class demo5 {
    //使用var和val定义属性
    var name: String = "SiberinDante"
    var age: Int = 18
    val gender: String = "男"

    fun test() {//类中定义方法
        val user = demo5()//创建类demo5的实例
        print(user.name)//输出name
    }

    class empty//定义一个空类
}