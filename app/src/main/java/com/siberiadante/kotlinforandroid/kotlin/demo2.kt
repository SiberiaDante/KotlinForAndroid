package com.siberiadante.kotlinforandroid.kotlin

/**
 * @Created： SiberiaDante
 * @Date： 2018/1/7
 * @Describe：
 * @Github： https://github.com/SiberiaDante
 * @Blog： http://www.cnblogs.com/shen-hua/
 */

class demo2 {
    fun testChar(charStr: Char) {
        if (charStr == '1') {
        }
    }

    fun testChar1() {
        var result: Boolean
        var isTure = true
        val charStr = '1'
        if (charStr in '0'..'9') {
            var result = (charStr.toInt() == 1)
        }
    }

    fun test3() {
        val name1 = "Siberia"
        val name2 = "Dante"
        val name = "My name is:$name1$name2"
        print(name)//输出结果：My name is SiberiaDante
        val nameLength = "$name 的长度是：${name.length}"//输出结果：SiberiaDante 的长度是：12
        print(nameLength)
    }

    fun test4() {
        val arr = arrayOf(1, 2, 3, 4, 5)//[1,2,3,4,5]
        var arr1: IntArray = intArrayOf(1, 2, 3, 4, 5)//[1,2,3,4,5]
        val arr2 = Array(5, { i -> (i * 2) })//[0,2,4,6,8]
    }
}

