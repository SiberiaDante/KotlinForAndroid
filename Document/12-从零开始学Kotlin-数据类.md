# 12-从零开始学Kotlin-数据类
https://www.kotlincn.net/docs/reference/data-classes.html
## 数据类的定义
* 我们经常创建一些只保存数据的类。 在这些类中，一些标准函数往往是从数据机械推导而来的。在 Kotlin 中，这叫做 数据类 并标记为 data：
```
    data class User(val name: String, val age: Int)
```

