# 5-从零开始学Kotlin-类和对象

### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)

## 定义一个类
* 定义一个类，使用关键字class声明，后面跟类名（不使用new）
```
    class demo5 {//定义一个类，使用关键字class声明，后面跟类名

        fun test() {//类中定义方法
        }

        class empty//定义一个空类
    }
```

## 定义类的属性
* 类的属性可以使用var和val定义
```
    class demo5 {
        var name: String = "SiberinDante"
        var age: Int = 18
        val gender: String = "男"
    }
```
* 创建类的实例以及获取类中的属性
```
    class demo5 {
        var name: String = "SiberinDante"
        var age: Int = 18
        val gender: String = "男"
        fun test() {
            val user = demo5()//创建类demo5的实例
            print(user.name)//输出name
        }
    }
```

## 类的修饰符： classModifier 和 accessModifier
* classModifier: 类属性修饰符，标示类本身特性。
```
   abstract    // 抽象类  
   final       // 类不可继承，默认属性
   enum        // 枚举类
   open        // 类可继承，类默认是final的
   annotation  // 注解类
``` 

* accessModifier: 访问权限修饰符
```a
    private    // 仅在同一个文件中可见
    protected  // 同一个文件中或子类可见
    public     // 所有调用的地方都可见
    internal   // 同一个模块中可见
```   

##  构造器：
* Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后,主构造器中不能包含任何代码
```
    class consClass constructor(tag: String) {}
```
* 主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
```
    class consClass constructor(name: String) {
        init {//初始化
        }
    }
```
* 主构造器的参数可以在初始化代码段中使用，也可以在类主体n定义的属性初始化代码中使用。
```
    class consClass constructor(name: String) {
    init {
        print("My name is $name")
    }
    }
```
* 次级构造函数，使用前缀 constructor修饰
```
    class cinsClass1 {
        constructor(age: Int, name: String) {}
    }
```
* 如果类有主构造函数，每个次构造函数都要直接或间接通过另一个次构造函数代理主构造函数。在同一个类中代理另一个构造函数使用 this 关键字：
```
    class consClass constructor(name: String) {
        constructor(name: String, age: Int) : this(name) {
            print("name is $name,age is $age")
        }
        constructor(name: String, age: Int, gender: String) : this(name, age) {
            print("name is $name,age is $age,gender is $gender")
        }
    }
```
* 构造函数是 public 的，如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数：
```
    class consClass2 private constructor() {}
```
* 在 JVM 虚拟机中，如果主构造函数的所有参数都有默认值，编译器会生成一个附加的无参的构造函数，这个构造函数会直接使用默认值。

## 抽象类
* 抽象类使用abstract修饰，抽象成员在类中不存在具体的实现。无需对抽象类或抽象成员标注open注解。
```
    open class BaseClass {
        open fun baseVoid() {}
    }
    abstract class SecondClass : BaseClass() {
        override abstract fun baseVoid()
    }
```

## 嵌套类
* 类中嵌套一个类
```
    class OuterClass {//外部类
        class NestedClass {//嵌套类
            fun showName() = "SiberiaDante"
        }
    }
    fun main(args: Array<String>) {
        val name = OuterClass.NestedClass().showName() // 调用格式：外部类.嵌套类.嵌套类方法/属性
        println("name is $name")
    }
```

## 内部类
* 内部类使用 inner 关键字来表示。内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。
```
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
```

## 匿名内部类
* 使用对象表达式来创建匿名内部类
```
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
```
