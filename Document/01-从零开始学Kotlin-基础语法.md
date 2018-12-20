# 1-从零开始学Kotlin-基础语法

### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)

### 注释
```aidl
    //单行注释
```
```aidl
    /*
    多行注释
     */
```
```aidl
    /**
     * 多行注释
     */
```
* 多行注释

### 定义变量/常量
* 变量定义：var 关键字
```
    var <标识符> : <类型> = <初始化值>
```
* 常量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
```
    val <标识符> : <类型> = <初始化值>
```
常量与变量都可以没有初始化值,但是在引用前必须初始化
```
    var name: String//不指定变量值时需要指定变量类型
    var name1="SiberiaDante"//指定变量值时不需要指定变量类型

    val name2:String//不指定常量值时需要指定类型
    val name3="SiberiaDante"//指定常量值时不需要指定类型
```
### 函数/方法
* 无返回值方法定义
```aidl
    /**
     * Unit 可以省略
     */
    fun demo1(): Unit  {}
```
```aidl
    fun demo1(name: String, age: Int) {
        print("My Name is " + name)
    }
```
* 有返回值的方法
```aidl
    /**
     *不定义返回值类型，系统判断
     */
    fun sum1(a: Int, b: Int) = a + b
```
```aidl
    /**
     * 定义返回类型Int
     */
    fun sum2(a: Int, b: Int): Int {
        return a + b
    }
```
* 变长参数方法(用varargs关键字标识)
```
fun showNums(vararg nums:Int){
    for(num in nums){//for 循环输出
        print(num)
    }
}
```
### Null检查机制

```
//类型后面加?表示可为空
var age: String? = "23" 
//抛出空指针异常
val ages = age!!.toInt()
//不做处理返回 null
val ages1 = age?.toInt()
//age为空返回-1
val ages2 = age?.toInt() ?: -1
```
使用案例:如下，字符串不是数字是，返回Null，返回类型需要标记为可为Null
```
fun strToInt(str:String):Int?{
	
}
```
### 日志打印
```
print("不换行打印")
println("换行打印")
```
### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)