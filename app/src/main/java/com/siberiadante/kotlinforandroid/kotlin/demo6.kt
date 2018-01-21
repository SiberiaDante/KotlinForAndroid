package com.siberiadante.kotlinforandroid.kotlin

import android.content.Context
import android.util.AttributeSet

/**
 * @Created： SiberiaDante
@Date： 2018/1/19
@Describe：
@Github： https://github.com/SiberiaDante
@Blog： http://www.cnblogs.com/shen-hua/
 */
open class demo6(name: String) : Any() {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }

    class Demo6test : demo6("SiberiaDante") {
    }

//    open class Person { //基类
//        fun man() {//不允许子类重写的方法
//            print("男人")
//        }
//
//        open fun women() {//允许子类重写方法
//            print("女人")
//        }
//    }

//    class Gender : Person() {
//        //子类
//        override fun women() {//重写父类方法
//            super.women()
//        }
//    }

    //属性重写
    open class BaseColor() {
        open val red: String = "Red"//可重写属性
    }

    class redColor : BaseColor() {
        override var red: String = "Red1"//重写基类属性
//        override val red: String//重写基类属性
//            get() = super.red
    }

    //    open class Person(var name : String, var age : Int){// 基类
//    }
//    class Student(name : String, age : Int, var no : String, var score : Int) : Person(name, age)
    open class Person(name: String) {
        constructor(name: String, age: Int) : this(name)
    }

    class Student : Person {
        constructor(name: String) : super(name)
        constructor(name: String, age: Int) : super(name, age)
    }
}