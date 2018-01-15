从零开始学Kotlin-控制语句（4）
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

