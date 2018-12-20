# 09-从零开始学Kotlin-枚举

### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)

## 枚举的定义
* 一个类的对象是有限且固定的，这种实例有限且固定的类称为枚举类;
* 枚举常量用逗号分隔,每个枚举常量都是一个对象;
```
    enum class EnumDemo9 {
        RED, BLUE, BLACK, WHITE
    }
```

## 枚举初始化
* 每一个枚举都是枚举类的实例，它们可以被初始化;枚举类的主构造函数默认是私有的,初始化时需要在主构造函数中声明;
```
    enum class EnumDemo91(val rgb: Int) {
        RED(0xff0000),
        BLUE(0x0011ff),
        BLACK(0x000000),
        WHITE(0xffffff),
    }
```

## 枚举的使用
* EnumClass.valueOf(value: String): 由枚举值的名称获取枚举实例；未匹配成功，会抛出IllegalArgumentException
* EnumClass.values(): 以数组的形式，获取所有的枚举实例
```
    fun main(args: Array<String>) {
        var colors: Array<EnumDemo91> = EnumDemo91.values()
        var redColor = EnumDemo91.valueOf("RED")
    }
```
* 每个枚举常数值都拥有属性,获取枚举相关信息:
    * val name: String //获取枚举名称
    * val ordinal: Int //获取枚举值在所有枚举数组中定义的顺序
```
    fun main(args: Array<String>) {
        val redColor = EnumDemo91.valueOf("RED")
        var redColorName = redColor.name
        var redColorOrdinal = redColor.ordinal
    }
```
* 自 Kotlin 1.1 起，可以使用 enumValues<T>() 和 enumValueOf<T>() 函数以泛型的方式访问枚举类中的常量
```
    print(enumValues<EnumDemo91>().joinToString { it.name })//输出：RED,BLUE,BLACK,WHITE
    print(enumValueOf<EnumDemo91>("RED"))//输出：RED
```

## 枚举类与接口
* 枚举类实现接口的情况与抽象方法类似，所有的枚举常量都应在其匿名类中实现接口的方法。
```
    //定义一个接口
    interface ItemClickListener {
         fun onClick(msg: String)
    }
    //枚举类继承接口
    enum class EnumDemo92 : ItemClickListener {
        BUTTON {
            override fun onClick(msg: String) {
                print(msg)
            }
        },
        IMAGE {
            override fun onClick(msg: String) {
                print(msg)
            }
        }
    }
```

## 匿名类与抽象方法
* 枚举还支持以声明自己的匿名类及相应的方法、以及覆盖基类的方法;
>* 在枚举类中声明了抽象方法，所有的枚举常量都应声明其匿名类，并在匿名类中实现枚举类中声明的抽象方法，如果不实现，编译器会报错;
>* 如果枚举类定义任何成员，要使用分号将成员定义中的枚举常量定义分隔开;
>* 匿名内部类中声明的方法，并不能在外部使用，即使是其枚举类型的实例，也不可调用;但重写的枚举类中声明的方法，可以被其实例调用;

```
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
```