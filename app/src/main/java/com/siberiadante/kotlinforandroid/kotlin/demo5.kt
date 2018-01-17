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
    //Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后
    class consClass constructor(name: String) {//主构造器中不能包含任何代码
    init {//初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
        print("My name is $name")
    }

        constructor(name: String, age: Int) : this(name) {
            print("name is $name,age is $age")
        }

        constructor(name: String, age: Int, gender: String) : this(name, age) {
            print("name is $name,age is $age,gender is $gender")
        }
    }

    class cinsClass1 {
        constructor(age: Int, name: String) {}
    }

    class consClass2 private constructor() {}

    open class BaseClass {
        open fun baseVoid() {}
    }

    abstract class SecondClass : BaseClass() {
        override abstract fun baseVoid()
    }

    class OuterClass {
        //外部类
        class NestedClass {
            //嵌套类
            fun showName() = "SiberiaDante"
        }
    }

    fun main(args: Array<String>) {
        val name = OuterClass.NestedClass().showName() // 调用格式：外部类.嵌套类.嵌套类方法/属性
        println("name is $name")
    }

    class OuterClass1 {
        private val age: Int = 18
        var name = "成员属性"

        inner class InnerClass { //内部类
            fun showAge() = age  // 内部类直接访问外部类成员

            fun innerTest() {
                val outerCls = this@OuterClass1 //创建外部类的实例
                println("获取外部类成员变量" + outerCls.name)//内部类可以引用外部类的成员
            }
        }
    }

    fun main1(args: Array<String>) {
        val age = OuterClass1().InnerClass().showAge()
        println("My age is $age")
        val demo2 = OuterClass1().InnerClass().innerTest()
        println(demo2)
    }

    /**
     * 定义接口
     */
    interface TestInterface {
        fun testInterface()
    }

    class AnonymousClass {
        fun setInterFace(test: TestInterface) {
            test.testInterface()
        }
    }
    fun main2(args: Array<String>) {
        var anonymousClass = AnonymousClass()
        /**
         * 采用对象表达式来创建接口对象，即匿名内部类的实例。
         */
        anonymousClass.setInterFace(object : TestInterface {
            override fun testInterface() {
                println("对象表达式创建匿名内部类的实例")
            }
        })
    }
}