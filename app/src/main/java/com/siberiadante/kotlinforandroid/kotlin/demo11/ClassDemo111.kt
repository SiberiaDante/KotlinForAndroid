package com.siberiadante.kotlinforandroid.kotlin.demo11

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/2/2
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
data class ClassDemo111(val name: String, val age: Int) {
    fun main() {
        val dante = ClassDemo111(name = "SiberiaDante", age = 18)
        val newDante = dante.copy(name = "ReadyGo~")
        print(dante)//输出结果：ClassDemo111(name = SiberiaDante, age = 18)
        print(newDante)//输出结果：ClassDemo111(name = ReadyGo~, age = 18)

        val (name, age) = dante
        print("$name ,$age years of age")  //输出：SiberiaDante, 18 years of age
    }
}