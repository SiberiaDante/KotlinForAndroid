package com.siberiadante.kotlinforandroid.kotlin

/**
 * @Created： SiberiaDante
@Date： 2017/12/31
@Describe：
@Github： https://github.com/SiberiaDante
@Blog： http://www.cnblogs.com/shen-hua/
 */
class demo1 {
    //单行注释
    /*
    多行注释
     */
    /**
     * 多行注释
     */
    /**
     * Unit 可以省略
     */
    fun demo1(): Unit  {
        var name: String//不指定变量值时需要指定变量类型
        var name1 = "SiberiaDante"//指定变量值时不需要指定变量类型

        val name2: String//不指定不可变变量值时需要指定不可变变量类型
        val name3 = "SiberiaDante"//指定不可变变量值时不需要指定不可变变量类型
    }

    fun demo1(name: String, age: Int) {
        print("My Name is " + name)
    }

    /**
     *不定义返回值类型，系统判断
     */
    fun sum1(a: Int, b: Int) = a + b

    /**
     * 定义返回类型Int
     */
    fun sum2(a: Int, b: Int): Int {
        return a + b
    }

    fun demo2(vararg v:Int){
        for(vt in v){
            print(vt)
        }
    }

    // 测试
    fun main(args: Array<String>) {
        demo2(1,2,3,4,5)  // 输出12345
    }
}