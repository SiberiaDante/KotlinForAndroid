# 06-从零开始学Kotlin-类的继承

### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)

## Kotlin中的超类Any
* Kotlin 中所有类都继承超类 Any 类
 ```
    class demo6 //默认继承超类Any
    class demo6 : Any()
```
* Any类有三个默认的函数
```
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
```
* 如果一个类想被其他类继承，使用open关键字修饰
```
    open class BaseClass (name:String) {//基类
    }
    class Demo6: BaseClass("SiberiaDante") {//继承基类
        }
```

## 类的构造函数的继承
* 如果子类有主构造函数，则基类必须在主构造函数中立即初始化。
```
    open class Person(var name : String, var age : Int){// 基类
    }
    class Student(name : String, age : Int, var no : String, var score : Int) : Person(name, age)

```
* 如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
```
    open class Person(name: String) {
        constructor(name: String, age: Int) : this(name)
    }

    class Student : Person {
        constructor(name: String) : super(name)//调用基类主构造
        constructor(name: String, age: Int) : super(name, age)//调用基类次级构造
    }
```

## 类中方法的重写
* 使用fun声明函数时默认为final修饰，不能被子类重写。如果基类允许子类重写该函数，则需要使用 open 关键字修饰, 子类重写方法使用 override 关键词：
```
    open class Person { //基类
        fun man() {//不允许子类重写的方法
            print("男人")
        }
        open fun women() {//允许子类重写方法
            print("女人")
        }
    }
    class Gender : Person() {//子类
        override fun women() {//重写父类方法
//            super.women()
        }
    }
```

## 类中属性的重写
* 属性的重写必须具有兼容类型，重写使用 override 关键字，每一个声明的属性都可以通过初始化程序或者getter方法被重写
```
    open class BaseColor() {
        open val red: String = "Red"//基类可重写的属性
    }
    
    class redColor : BaseColor() {
        override val red: String="Red1"//重写基类属性
        override val red: String//重写基类属性
            get() = super.red
    }
```
* 可以var属性重写val属性，但不能用val属性重写var属性。因为val属性本身定义了getter方法，重写为var属性会在衍生类中额外声明一个setter方法
```
    open class BaseColor() {
        open val red: String = "Red"//基类可重写的属性
    }
    
    class redColor : BaseColor() {
        override var red: String="Red1"//重写基类属性
        override var red: String//重写基类属性
            get() = super.red
    }
```
