从零开始学Kotlin-操作符（3）
## 比较符
Kotlin 中没有基础数据类型，只有封装的数字类型，你每定义的一个变量，其实 Kotlin 帮你封装了一个对象，这样可以保证不会出现空指针。比较两个数据大小用"==",比较两个对象地址使用"===";
```
var a:Int = 100
print(a===a)	结果：true

var b:Int =a
var c:Int =a
print(b===c)	结果：false
print(b==c)		结果：true
```
## 位操作符