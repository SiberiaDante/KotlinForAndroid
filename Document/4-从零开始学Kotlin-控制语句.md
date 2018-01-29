从零开始学Kotlin-控制语句（4）

### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)

## 条件控制-if
```
        var a=10
        var b=20
        if(a>b) print(a)
        if(a>b){
            print(a)
        }else{
            print(b)
        }
        val max = if( a > b) a else b
        if ( a in 1..10){
            print("a在1到10区间内")
        }
```
## 条件控制-when
```
        val x = 3
        when (x) {
            1 -> print("x 是1")
            2 -> print("x 是2")
            else -> print("x 不是1也不是2")
        }
        when (x) {
            1, 2 -> print("x 是1或者2")
            else -> print("x 不是1也不是2")
        }
        when (x) {
            in 1..5 -> print("x 在1-5中")
            !in 5..10 -> print("x不在5-10中")
            else -> print("x 不是1也不是2")
        }
```
## 循环控制-for
```
        val ints = arrayOf(1, 2, 3, 4, 5)
        for (num: Int in ints) {//循环遍历数值
            print((num))
        }
        for (index in ints.indices) {//循环遍历索引和值
            print("$index 位置的数是 ${ints[index]}")
        }
```
## 循环控制-while/do...while
```
        var a = 10
        while (a < 10) {
            print("a < 10")
            a++
        }
        do {
            print("先输出一下再去判断")
            a++
        } while (a < 10)
```
## 跳转表达式 return、break、continue
* 常规用法
```
    for (i in 1..10) {
        if (i == 3) continue//i==3时跳出该循环执行下一轮循环
            print(i)
        if (i > 5) break//i>5时跳出循环或者说终止循环
        if (i == 8) return //i==8时终止循环以及终止以下步骤
     }
```
* 在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号，例如：name@、number@等
```
number@ for (i in 1..10){
}
```
* 标签结合break和continue使用
```
        loop1@ for (i in 1..100) {
            loop2@ for (j in 1..100) {
                if (i == j) break@loop1
                if (i % j == 0) continue@loop1
            }
        }
```
* 标签结合return使用
```
    fun test5() {
        var ints = arrayOf(0, 1, 2, 3, 4, 5)
        /**
         * 这种return其实是直接return了test5（）这个方法
         */
        ints.forEach {
            if (it == 0) return
            print(it)
        }
        /**
         * 如果想只return到当前循环，则需要结合标签使用
         */
        ints.forEach currentLoop@ {
            if (it == 0) return@currentLoop
            print(it)
        }
    }
```
### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)