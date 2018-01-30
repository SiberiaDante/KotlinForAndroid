package com.siberiadante.kotlinforandroid.kotlin.demop10

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/30
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
class ClassDemo10 {
    fun ClassDemo10.showMsg(name: String) {//扩展函数
        print(name)
    }

    fun MutableList<Int>.swap(index: Int, index1: Int) {//扩展系统函数，调换位置
        val tmp = this[index]
        this[index] = this[index1]
        this[index1] = tmp
    }


    open class Person
    class Student : Person()

    fun Person.getInfo() = "Person Info"//扩展Person类方法
    fun Student.getInfo() = "Student Info"//扩展Student类方法

    fun printMsg(person: Person) {
        print(person.getInfo())//此处指定为Person类型
    }

    fun main() {
        printMsg(Student())//输出结果：Person Info
    }

    class Teacher {
        fun doWork() {
            print("成员函数")
        }
    }

    fun Teacher.doWork() {
        print("扩展函数")
    }

    fun showDoWork() {
        val teacher = Teacher()
        teacher.doWork()//输出结果：成员函数
    }

    //扩展一个空对象
    fun Teacher?.printMsf(): String {
        if (this == null) return "null"
        return "我是Teacher"
    }

    fun main1() {
        val teacher = null
        print(teacher.printMsf())//输出结果为：null
        val rTeacher = Teacher()
        print(rTeacher.printMsf())//输出结果：我是Teacher
    }


    //属性扩展
    val <T> List<T>.lastIndex: Int//扩展一个获取List最后一个索引的方法
        get() = size - 1

    class ClassDemo {
        companion object {
        }

        fun ClassDemo.Companion.showMsg() {
            print("伴生对象的扩展函数")
        }

        val ClassDemo.Companion.name: String
            get() = "伴生对象的扩展属性"
    }
}