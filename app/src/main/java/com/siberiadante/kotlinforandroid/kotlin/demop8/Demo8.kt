package com.siberiadante.kotlinforandroid.kotlin.demop8

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/27
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
class Demo8<T>(date: T) {
    var todayDate = date
    //    val demo1: Demo8<String> = Demo8<String>("2018-01-27")
//    val demo2: Demo8<String> = Demo8("2018-01-27")
//    val demo3 = Demo8("2018-01-27")

    val demo1: Demo8<Int> = Demo8<Int>(20180127)
    val demo2: Demo8<Int> = Demo8(20180127)
    val demo3 = Demo8(20180127)

    fun <T> showMsg(msg: T) {

    }

    val msg = showMsg("泛型的使用")
    val msg1 = showMsg(200)
    val msg2 = showMsg<String>("指定返回类型")
    //结合while循环使用

    fun <T> showPrint(printMsg: T) {
        when (printMsg) {
            is Int -> println("printMsg是Int类型：$printMsg")
            is String -> println("printMsg是String类型：$printMsg")
            else -> println("printMsg类型未知：$printMsg")
        }
    }

//    fun main() {
//        showMsg(100)
//        showMsg("2017-01-27")
//        showMsg(true)
//    }

    //约束
//    fun <T : Comparable<T>> sort(list: List<T>) {
//    }

    //    fun main() {
//        sort(listOf(1, 2, 3))//正确
//        sort(listOf("1", "2", "3"))//正确
//        sort(listOf(HashMap<Int,String>))//错误， HashMap<Int, String> 不是 Comparable<HashMap<Int, String>> 的子类型
//    }

    //泛型约束 <占位符:类型>
    fun <T : Number> play(vararg param: T): Double {
        return param.sumByDouble { it.toDouble() }
    }

    //多个约束，T有多个上限 , where T:类型,T:类型
    fun <T> getBetterBig(list: Array<T>, threhold: T): List<T> where T : Number, T : Comparable<T> {
        return list.filter { it >= threhold }.sorted()
    }
}
