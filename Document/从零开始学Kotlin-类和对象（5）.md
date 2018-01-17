## 从零开始学Kotlin-类和对象（5）
## 定义一个类
```
    class demo5 {//定义一个类，使用关键字class声明，后面跟类名

        fun test() {//类中定义方法
        }

        class empty//定义一个空类
    }
```
## 定义类的属性
* 类的属性可以使用var和val定义
``` class demo5 {
        var name: String = "SiberinDante"
        var age: Int = 18
        val gender: String = "男"
    }
```
*
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
