# 从零开始学Kotlin-数据类型（2）
## 基本数据类型
* Kotlin 的基本数值类型包括 Byte、Short、Int、Long、Float、Double 等；
```
数据-------位宽度
Double-----64
Float------32
Long-------64
Int--------32
Short------16
Byte-------8
```
* 常量表示(不支持8进制)
```
十进制：520
长整型以大写的 L 结尾：5201314L
16 进制以 0x 开头：0x0F
2 进制以 0b 开头：0b00001011
```
* 为了使数字易读，Kotlin中可以使用如下形式表示数字
```
8_888_888
888_888_888_888_888L
0xFF_EC_DE_5E
0b01001001_11000011_11111111
```
## 基本数据类型转换
* 较小的类型不能隐式转换为较大的类型，可以通过显示转换
```
var a:int=10;//定义一个Int数据
var b:Long=a;//Int不能直接转换为Long型
var b:Long=a.toLong()//可以通过显示转换
```
* 几种类型转换方法
```
toByte(): Byte
toShort(): Short
toInt(): Int
toLong(): Long
toFloat(): Float
toDouble(): Double
toChar(): Char
```
## 字符串
* 定义字符串
```
var name="SiberiaDante"
```
* Kotlin支持多行字符串
```
val textContent="""
    第一行文字
    第二行文字
    第三行文字
    """
```
* 字符串拼接，$表达式
```
al name1 = "Siberia"
val name2 = "Dante"
val name = "My name is:$name1$name2"
print(name)         //输出结果：My name is SiberiaDante
val nameLength = "$name 的长度是：${name.length}"
print(nameLength)   //输出结果：SiberiaDante 的长度是：12
```
## 字符
* 在Kotlin中，字符不能直接和数字一起操作，字符必须使用单引号括起来，如：'A','B';
```
var charStr: Char = '1'
if(charStr==1)//不能和数字比较，错误
if(charStr=='1')//正确
```
* 可以把字符显示转换为数字，再进行比较
```
val charStr = '1'
if (charStr in '0'..'9') {
    var result = (charStr.toInt() == 1)
}
```
## 布尔类型
* 布尔用 Boolean表示，它有两个值：true 和 false。两个Boolean类型的数值的逻辑比较跟Java一样
```
var result:Boolean
var isTure=true
```
## 数组
* 定义一个基本的数组
```
val arr= arrayOf(1,2,3,4,5)//[1,2,3,4,5]
var arr1:IntArray= intArrayOf(1,2,3,4,5)//[1,2,3,4,5]
val arr2 = Array(5, { i -> (i * 2) })//[0,2,4,6,8]
```
* 除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高，其用法同Array一样：

[关注我-Github-https://github.com/SiberiaDante](https://github.com/SiberiaDante)