# 07-从零开始学Kotlin-使用接口

### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)

## 定义接口
* 使用关键字interface定义接口
```
    interface InterfaceDemo7 {
    }
```
* 类或对象可以实现一个或者多个接口
```
    class demo7 : InterfaceDemo7 {
    }
    class demo : InterfaceDemo71, InterfaceDemo72 {
    }
```

## 接口中定义属性
* 接口中的属性只能是抽象的，不允许初始化值
```
    interface InterfaceDemo7 {
        val name: String
        var gender:String
    }
```
* 类实现接口的属性：接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性
```
    class demo7 : InterfaceDemo7 {
        override val name: String = "SiberiaDante"
        override var gender: String = "男"
    }
```

## 接口中定义方法
* 接口中定义方法，方法可以直接被实现，也可以不实现
```
    interface InterfaceDemo7 {
        fun voidOne()//定义一个方法,子类必须要实现该方法
        fun voidTwo() {//定义一个方法，并实现；子类可以不实现该方法
            print("接口已经实现了这个方法")
        }
    }
```
* 类实现接口并实行其中的方法
```
    class demo7 : InterfaceDemo7 {
        override fun voidOne() {//实现接口中未实现的方法子类必须要实现
        }
//      override fun voidTwo() {//接口中实现的方法，子类可以不实现
//          super.voidTwo()
//    }
    }
```
* 类实现多个接口，且接口有一个共同的方法，需要指明类如何实现它们:使用super.<接口名>.方法名指定使用哪个方法
```
    interface InterfaceDemo71 {
        fun showName()
        fun showAge() {
            print(18)
        }
    }
    interface InterfaceDemo72 {
        fun showName() {
            print("SiberiaDante")
        }
        fun showAge() {
            print(18)
        }
    }
```
```
    class demo : InterfaceDemo71, InterfaceDemo72 {
        override fun showName() {
        }
        override fun showAge() {//两个接口都有showAge()方法
            super<InterfaceDemo71>.showAge()//使用super.<接口名>.方法名指定使用哪个方法
            super<InterfaceDemo72>.showAge()
        }
    }
```