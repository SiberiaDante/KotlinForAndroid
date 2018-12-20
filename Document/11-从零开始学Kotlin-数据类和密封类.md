# 11-从零开始学Kotlin-数据类和密封类

### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)

## 数据类的定义
* 我们经常创建一些只保存数据的类。 在这些类中，一些标准函数往往是从数据机械推导而来的。在 Kotlin 中，这叫做 数据类 并标记为 data：
```
    data class User(val name: String, val age: Int)
```
* 编译器会自动的从主构造函数中根据所有声明的属性提取以下函数：
```
    equals() / hashCode()
    toString() 格式如 "User(name=John, age=42)"
    componentN() 函数 对应于属性，按声明顺序排列
    copy() 函数
```
>* 如果在数据类体中有显式实现 equals()、 hashCode() 或者 toString()，或者这些函数在父类中有 final 实现，那么不会生成这些函数，而会使用现有函数;
>* 如果超类型具有 open 的 componentN() 函数并且返回兼容的类型， 那么会为数据类生成相应的函数，并覆盖超类的实现。如果超类型的这些函数由于签名不兼容或者是 final 而导致无法覆盖，那么会报错;
* 为了确保生成的代码的一致性和有意义的行为，数据类必须满足以下要求:
>* 主构造函数需要至少有一个参数；
>* 主构造函数的所有参数需要标记为 val 或 var；
>* 数据类不能是抽象、开放、密封或者内部的；
>* 在1.1版本之前数据类只能实现接口,在1.1版本起，数据类可以扩展其他类

## 复制
*  copy() 函数，复制一个对象改变它的一些属性，但其余部分保持不变；
```
    data class User(val name: String, val age: Int) {
        fun main() {
            val dante = User(name = "SiberiaDante", age = 18)
            val newDante = dante.copy(name = "ReadyGo~")
            print(dante)//输出结果：User(name = SiberiaDante, age = 18)
            print(newDante)//输出结果：User(name = ReadyGo~, age = 18)
        }
    }
```

## 数据类和解构声明
* 解构声明：有时把一个对象 解构 成很多变量会很方便，这种语法称为 解构声明；一个解构声明同时创建多个变量；
```
    data class User(val name: String, val age: Int) {
        fun main() {
            val dante = User(name = "SiberiaDante", age = 18)
            val (name, age) = dante
            print("$name ,$age years of age")  //输出：SiberiaDante, 18 years of age
        }
    }
```

## 密封类
* 密封类用来表示受限的类继承结构：当一个值为有限集中的类型、而不能有任何其他类型时。在某种意义上，他们是枚举类的扩展：枚举类型的值集合也是受限的，但每个枚举常量只存在一个实例，而密封类的一个子类可以有可包含状态的多个实例；
* 要声明一个密封类，需要在类名前面添加 sealed 修饰符。虽然密封类也可以有子类，但是所有子类都必须在与密封类自身相同的文件中声明
* 密封类sealed 不能修饰 interface ,abstract class(会报 warning,但是不会出现编译错误)
```
    sealed class Expr
    data class Const(val number: Double) : Expr()
    data class Sum(val e1: Expr, val e2: Expr) : Expr()
    object NotANumber : Expr()

    fun eval(expr: Expr): Double = when (expr) {
        is Const -> expr.number
        is Sum -> eval(expr.e1) + eval(expr.e2)
        NotANumber -> Double.NaN
    }
```
* 使用密封类的关键好处在于使用 when 表达式 的时候，如果能够 验证语句覆盖了所有情况，就不需要为该语句再添加一个 else 子句了;
