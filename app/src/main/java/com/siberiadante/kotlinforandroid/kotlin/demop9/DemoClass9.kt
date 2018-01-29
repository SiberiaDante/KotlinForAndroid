package com.siberiadante.kotlinforandroid.kotlin.demop9

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/29
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
class DemoClass9 {
    fun main(args: Array<String>) {
        var colors: Array<EnumDemo91> = EnumDemo91.values()
        val redColor = EnumDemo91.valueOf("RED")
        var redColorName = redColor.name
        var redColorOrdinal = redColor.ordinal
        //自 Kotlin 1.1 起，可以使用 enumValues<T>() 和 enumValueOf<T>() 函数以泛型的方式访问枚举类中的常量 ：
        print(enumValues<EnumDemo91>().joinToString { it.name })//输出：RED,BLUE,BLACK,WHITE
        print(enumValueOf<EnumDemo91>("RED"))//输出：RED
    }
    /*
    为什么选择Kotlin
；
     */
}
