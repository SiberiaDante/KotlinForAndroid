从零开始学Kotlin-操作符（3）
http://blog.csdn.net/dangnianmingyue_gg/article/details/75305504
## 比较符"=="和"==="
Kotlin 中没有基础数据类型，只有封装的数字类型，你每定义的一个变量，其实 Kotlin 帮你封装了一个对象，这样可以保证不会出现空指针。
* "=="比较两个数值大小
* "==="比较两个对象地址
```
var a:Int = 100
print(a===a)	结果：true

var b:Int =a
var c:Int =a
print(b===c)	结果：false
print(b==c)		结果：true
```
## Null检查机制符"？"、"？："和"!!" 
* "？"表示这个对象可以为空
```
//类型后面加?表示可为空
var age: String? = "23" 
```
* "？："表示非空则使用，否则返回指定数值
```
//a不为空，返回a的长度，否则返回-1
val 1ength==a?.length?:-1
//相当于
val length:Int=if(a!=null)a.length else -1
```
* "!!" 
## 位操作符