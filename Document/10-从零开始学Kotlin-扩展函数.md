# 10-从零开始学Kotlin-扩展函数

## 什么是扩展函数
>* 扩展函数数是指在一个类上增加一种新的行为，我们甚至没有这个类代码的访问权限；
>* Kotlin 可以对一个类的属性和方法进行扩展，且不需要继承或使用 Decorator 模式；
>* 扩展是一种静态行为，对被扩展的类代码本身不会造成任何影响。

## 扩展函数
* 扩展函数可以在已有类中添加新的方法，不会对原类做修改；
```
    //扩展函数定义形式：
    fun receiverType.functionName(params){
        body
    }
```
>* receiverType：表示函数的接收者，也就是函数扩展的对象
>* functionName：扩展函数的名称
>* params：扩展函数的参数，可以为NULL
```
    class ClassDemo {
        fun ClassDemo.showMsg(name: String) {//扩展函数
            print(name)
        }
    }
    fun MutableList<Int>.swap(index: Int, index1: Int) {//扩展系统函数，调换位置
        //his关键字指代接收者对象(receiver object)，
        val tmp = this[index]
        this[index] = this[index1]
        this[index1] = tmp
    }
```
* 扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:；
```
    open class Person
    class Student : Person()

    fun Person.getInfo() ="Person Info"//扩展Person类方法
    fun Student.getInfo() ="Student Info"//扩展Student类方法

    fun printMsg(person: Person) {
        print(person.getInfo())//此处指定为Person类型
    }

    fun main() {
        printMsg(Student())//输出结果：Person Info
    }
```
* 若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数；
```
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
```

## 扩展一个空对象
* 在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数
```
    fun Teacher?.printMsf(): String {
        if (this == null) return "null"
        return "我是Teacher"
    }

    fun main() {
        val teacher = null
        print(teacher.printMsf())//输出结果为：null
        val rTeacher = Teacher()
        print(rTeacher.printMsf())//输出结果：我是Teacher
    }
```

## 扩展属性
* 扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。初始化属性因为属性没有后端字段（backing field），所以不允许被初始化，只能由显式提供的 getter/setter 定义;
```
    val <T> List<T>.lastIndex: Int//扩展一个获取List最后一个索引的方法
        get() = size - 1
```

## 伴生对象的扩展
* 如果一个类定义有一个伴生对象,也可以为伴生对象定义扩展函数和属性;伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用：
```
    class ClassDemo {
        companion object {
        }

        fun ClassDemo.Companion.showMsg() {
            print("伴生对象的扩展函数")
        }

        val ClassDemo.Companion.name: String
            get() = "伴生对象的扩展属性"
    }
```

## 作用域
* 通常扩展函数或属性定义在顶级包下
```
    //1、在包名.demop10下创建一个类 ClassDemo11
    package com.siberiadante.kotlinforandroid.kotlin.demop10
    class ClassDemo11

    //2、新建一个 ExtendFunction.kt 文件，在改文件中创建 ClassDemo11 的扩展函数
    package com.siberiadante.kotlinforandroid.kotlin.demop10
    fun ClassDemo11.showMsg(msg: String) {
    // ClassDemo11 的扩展函数
    }
```
* 要使用所定义包之外的一个扩展, 通过import导入扩展的函数名进行使用；
```
    //ClassDemo12 中使用扩展函数
    package com.siberiadante.kotlinforandroid.kotlin
    //常规导入
    import com.siberiadante.kotlinforandroid.kotlin.demop10.ClassDemo11
    import com.siberiadante.kotlinforandroid.kotlin.demop10.showMsg
    //导入demop10下的一切
    //import com.siberiadante.kotlinforandroid.kotlin.demop10.*

    class ClassDemo12 {//调用扩展函数
        fun main(classDemo11: ClassDemo11) {
            classDemo11.showMsg("调用另一个类的扩展函数")
        }
    }
```

## 扩展声明为成员
* 在一个类的内部可以为另一个类声明扩展，在这个扩展中，有个多个隐含的接收者，其中扩展方法定义所在类的实例称为分发接收者，而扩展方法的目标类型的实例称为扩展接受者；
```
    class ClassA {//扩展接收者
        fun showMsg() { println("ClassA showMsg") }
    }

    class ClassB {//分发接收者
        fun showMsg() { println("ClassB showMsg") }

        fun ClassA.printMsg() {
        // 为 ClassA 声明的扩展函数
        }
    }
```
* 调用某一个函数，而该函数在分发接受者和扩展接受者均存在，则以扩展接收者优先；要引用分发接收者的成员需要使用限定的 this 语法；
```
    class ClassA {//扩展接收者
        fun showMsg() { println("ClassA showMsg") }
    }

    class ClassB {//分发接收者
        fun showMsg() { println("ClassB showMsg") }

        fun ClassA.printMsg() {
            showMsg()   //扩展接收者（ClassA）的函数
            this@ClassB.showMsg()   //分发接收者（ClassB）的函数;语法：this@分发接收者.函数
        }
    }
```
* 以成员的形式定义的扩展函数, 可以声明为 open , 而且可以在子类中覆盖;
```
    open class ClassC

    open class ClassC1 : ClassC()

    open class ClassD {
        open fun ClassC.showMsg() {//ClassC 的扩展函数
            print("ClassC msg --- ClassD")
        }

        open fun ClassC1.showMsg() {//ClassC1 的扩展函数
            print("ClassC1 msg --- ClassD")
        }

        fun printMsg(c: ClassC) {
            c.showMsg()//调用ClassC 的扩展函数
        }
    }

    class ClassD1 : ClassD() {
        override fun ClassC.showMsg() {
            print("ClassC msg --- ClassD1")
        }

        override fun ClassC1.showMsg() {
            print("ClassC1 msg --- ClassD1")
        }
    }

    fun main9() {
        //ClassD调用ClassC的showMsg
        ClassD().printMsg(ClassC()) // 输出：ClassC msg --- ClassD
        //调用ClassD1调用自己重载的ClassC的showMsg
        ClassD1().printMsg(ClassC())    //输出：ClassC msg --- ClassD1
        //ClassD调用printMsg，printMsg受ClassC限制
        ClassD().printMsg(ClassC1())    //输出：ClassC msg --- ClassD
    }
```


