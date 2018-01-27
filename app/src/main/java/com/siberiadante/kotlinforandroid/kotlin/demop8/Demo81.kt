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
class Demo81 {
    open class Person(name: String) {
        var myName = "Siberiadante"
    }

    open class Student(name: String) : Person("PersonA")
    class Teacher(name: String) : Student("StudentA")

    fun main() {
        var person = Person("PersonA")
        var personList: ArrayList<Person> = arrayListOf(person)

        var student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        var teacher = Teacher("TeacherA")
        var teacherList: ArrayList<Teacher> = arrayListOf(teacher)

        for (name in personList.withIndex()) {
            println("name is $name")//输出：name is PersonA
        }

        for (name in studentList.withIndex()) {
            println("name is $name")//输出：name is StudentA
        }
        for (name in teacherList.withIndex()) {
            println("name is $name")//输出：name is TeacherA
        }

        person = student//正确，因为 Student 是 Person 的子类
        /*
        编译报错，类型不匹配：Required ArrayList<Person> Found ArrayList<Student>
        这是因为，虽然 Student 是 Person 的子类，但是 ArrayList<Student> 并不是 ArrayList<Person> 的子类
         */
//        personList = studentList

    }

    //为消除这种异常，Kotlin使用协变注解修饰符out进行类型修饰
    fun main1() {
        var person = Person("PersonA")
        var personList: ArrayList<out Person> = arrayListOf(person)

        var student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        personList = studentList//编译正确，这是因为 ArrayList<out Person> 限定了子类的上限为 Person

        for (name in personList.withIndex()) {
            println("name is $name")//输出：name is StudentA
        }
    }

    fun main2() {
        val person = Person("PersonA")
        val personList: ArrayList<Person> = arrayListOf(person)

        val student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        val teacher = Teacher("TeacherA")
        var teacherList: ArrayList<Teacher> = arrayListOf(teacher)

        /*
        以下两种均报类型不匹配错误，
         */
//        teacherList = personList//Required ArrayList<Teacher> Found ArrayList<Person>
//        teacherList = studentList//Required ArrayList<Teacher> Found ArrayList<Student>

        for (name in personList.withIndex()) {
            println("name is $name")//输出：name is StudentA
        }
    }

    //ArrayList<? super Class> 一模一样 <in Class>就是允许Kotlin的超类，类型下限为Kotlin
    fun main3() {
        val person = Person("PersonA")
        val personList: ArrayList<Person> = arrayListOf(person)

        val student = Student("StudentA")
        val studentList: ArrayList<Student> = arrayListOf(student)

        val teacher = Teacher("TeacherA")
        var teacherList: ArrayList<in Teacher> = arrayListOf(teacher)// <in Teacher> 就是允许 Teacher 的超类类型下限为 Teacher

        for (name in teacherList.withIndex()) {
            println("name is $name")//输出：name is TeacherA
        }

        teacherList = personList
        for (name in teacherList.withIndex()) {
            println("name is $name")//输出：name is PersonA
        }

        teacherList = studentList
        for (name in teacherList.withIndex()) {
            println("name is $name")//输出：name is StudentA
        }
    }

    fun main4() {
        val person = Person("PersonA")
        var personList: ArrayList<Person> = arrayListOf(person)

        val student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        personList.add(student)//set 设置值
        personList[0].myName// get 取值
    }

    fun main5() {
        val person = Person("PersonA")
        var personList: ArrayList<out Person> = arrayListOf(person)

        val student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        /*
        prohibits(禁止) use of public open fun add(element:E) !
         */
//        personList.add(student)//set 设置值,编译不通过
        personList[0].myName// get 取值
    }

    fun main6() {
        val person = Person("PersonA")
        var personList: ArrayList<in Person> = arrayListOf(person)

        val student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        personList.add(student)//set 设置值
        /*
        Unresolved reference : name,
         */
//        personList[0].myName// get 取值，编译不通过
    }

    fun main7() {
        var list: ArrayList<*> = arrayListOf(100) //<*>必不可少 相当于java的无泛型
    }

    fun main8() {
        val person = Person("PersonA")

        val student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        /*
        相当于  var personList: ArrayList<out Person> = studentList
         */
        var personList: ArrayList<*> = studentList
    }
    fun main9() {
        val person = Person("PersonA")
        val personList: ArrayList< Person> =arrayListOf(person)

        val student = Student("StudentA")

        /*
        相当于 val studentList:ArrayList<in Student> =personList
         */
        val studentList:ArrayList<*> =personList
    }
}