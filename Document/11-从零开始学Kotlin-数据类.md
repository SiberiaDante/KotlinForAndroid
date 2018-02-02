# 11-从零开始学Kotlin-数据类
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
* 为了确保生成的代码的一致性和有意义的行为，数据类必须满足以下要求：
>* 主构造函数需要至少有一个参数;
>* 主构造函数的所有参数需要标记为 val 或 var;
>* 数据类不能是抽象(abstract)、开放(open)、密封(sealed)或者内部的(inner);
>* 在1.1版本之前数据类只能实现接口，1.1版本之后数据类可以扩展其他类;
>* 在 JVM 中，如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值;

## 复制
* copy() 函数，复制一个对象改变它的一些属性，但其余部分保持不变；
```

```


