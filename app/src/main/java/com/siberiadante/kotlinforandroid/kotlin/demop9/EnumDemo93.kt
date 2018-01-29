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
enum class Person(var code: Int) {
    NAME1(0) {
        override fun showName(name: String): Person {
            return Person.values()[0]
        }
    },
    NAME2(1) {
        override fun showName(name: String): Person = NAME2
    };

    abstract fun showName(name: String): Person
}