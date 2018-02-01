# 12-从零开始学Kotlin-数据类
https://www.kotlincn.net/docs/reference/data-classes.html
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
