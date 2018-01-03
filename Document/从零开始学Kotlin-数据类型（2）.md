# 从零开始学Kotlin-数据类型（2）
## 基本数据类型
* Kotlin 的基本数值类型包括 Byte、Short、Int、Long、Float、Double 等；
```
数据		位宽度
Double	64
Float	32
Long	64
Int		32
Short	16
Byte	8
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

## 字符/字符串
* 定义字符串
```
var name="SiberiaDante"
```
* 字符串拼接
```
val name1="Siberia"
val name2="Dante"
val name="My name is:$name1 $name2"
```