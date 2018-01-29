从零开始学Kotlin-操作符（3）

### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)

## 冒号操作符 ":" 和 "::"
* :操作符用来定义变量、类的继承等
```
var name: String//定义变量
class MainActivity : AppCompatActivity()//继承类
```
* ::可以用来得到类的Class对象
```
startActivity(Intent(this@MainActivity, SecondActivity::class.java))//得到SecondActivity对象
```
## 比较符"=="和"==="
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
## 属于操作符 "is"
is操作符可以用来判断某个实例是否属于另一个实例
```
if (name is String){ //name 是否是String 类型
    print(true)
}
```
## 模板操作符 "$"
模板操作符可以输出一个变量值
```
var name="SiberiaDante"
print("My name is $name")//输出结果：My name is SiberiaDante
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
* "!!" 操作符
```
val l = b!!.length//非空b,如果b为空，抛出空指针
```
## 区间操作符".."、"until"、"in"、"！in"和"downTo()"、"step()"函数
* ..闭区间操作符，代表在a到b区间类，包含a和a；until半闭区间操作符，代表a到b区间，包含a不包含b；
* in操作符，代表i 在某一个区间类；!in 代表i不在某一个区间类
```
if(i in 1..10){ //如果i在1到10十个数之间，就输出i
    print (i)
}

if(i !in 1..10){ //如果i不在1到10十个数之间，就输出i
    print (i)
}

if(i in 1 until 10){ //如果i在1到10九个数之间（不包含10），就输出i
    print (i)
}
```
* downTo()函数：倒叙区间内循环，a 到 b区间到倒叙
```
for(i in 5 downTo 1){
    print(i)//输出结果：54321
}
```
* step（）函数，跳跃式函数
```
for(i in 5..1 step 2){
    print(i)//输出结果：531
}
```
