# 8-从零开始学Kotlin-泛型

### [从零开始学Kotlin基础篇系列文章](https://github.com/SiberiaDante/KotlinForAndroid)


>与 Java 一样，Kotlin 也提供泛型，为类型安全提供保证，消除类型强转的烦恼。

## 泛型类的基本使用
* 泛型，即 "参数化类型"，将类型参数化，可以用在类，接口，方法上
```
    class DemoClass<T>(date: T) {//date是任意类型的，避免强转
        var todayDate=date
    }
```
* 创建类的实例时我们需要指定类型参数
```
    //指定泛型date为String，三种创建方法
    val demo1: DemoClass<String> = DemoClass<String>("2018-01-27")
    val demo2: DemoClass<String> = DemoClass("2018-01-27")
    val demo3 = DemoClass("2018-01-27")
```
```
    //指定泛型date为Int，三种创建方法
    val demo1: DemoClass<Int> = DemoClass<Int>(20180127)
    val demo2: DemoClass<Int> = DemoClass(20180127)
    val demo3 = DemoClass(20180127)
```

## 泛型方法的基本使用
* Kotlin 泛型函数的声明与 Java 相同，类型参数要放在函数名的前面：
```
    fun <T> showMsg(msg: T) {
    }
```
* 在调用泛型函数时，如果可以推断出类型参数，可以省略泛型参数
```
    val msg = showMsg("泛型的使用")
    val msg1 = showMsg(200)
    val msg2 = showMsg<String>("指定返回类型")
```
* 泛型结合when控制语句实例
```
    fun <T> showPrint(printMsg: T) {
        when (printMsg) {
            is Int -> println("printMsg是Int类型：$printMsg")
            is String -> println("printMsg是String类型：$printMsg")
            else -> println("printMsg类型不是Int也不是String：$printMsg")
        }
    }

    fun main() {
        showMsg(100)
        showMsg("2017-01-27")
        showMsg(true)
    }
```

## 泛型约束
* 对于给定的参数, 所允许使用的类型, 可以通过泛型约束(generic constraint) 来限制。冒号之后指定的类型就是类型参数的上界(upper bound)， 对于类型参数 T , 只允许使用 Comparable<T>的子类型
```
    fun <T : Comparable<T>> sort(list: List<T>) {//上界约束
    }

    fun main() {
        sort(listOf(1, 2, 3))//正确
        sort(listOf("1", "2", "3"))//正确
        sort(listOf(HashMap<Int,String>))//错误， HashMap<Int, String> 不是 Comparable<HashMap<Int, String>> 的子类型
    }
```
* 默认的上界是 Any?,对于多个上界约束条件，可以用 where 子句：
```
    //多个约束，T有多个上限 , where T:类型,T:类型
    fun <T> getBetterBig(list: Array<T>, threhold: T): List<T> where T : Number, T : Comparable<T> {
        return list.filter { it >= threhold }.sorted()
    }
```

## 泛型协变
* Kotlin 中没有通配符类型，它有两个其他的东西：声明处型变（declaration-site variance）与类型投影（type projections）。
* 声明处的类型变异使用协变注解修饰符：in、out，消费者 in, 生产者 out。
* out 修饰符；这里比较难理解，先举一个例子
```
    //创建两个类，继承关系
    open class Person(name: String)
    open class Student(name: String) : Person("PersonA")
    class Teacher(name: String) : Student("StudentA")

    fun main() {
        var person = Person("PersonA")
        var personList: ArrayList<Person> = arrayListOf(person)

        var student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        var teacher = Teacher("TeacherA")
        var teacherList: ArrayList<Teacher> = arrayListOf(teacher)

        for (name in personList.withIndex()) {
            println("name is $name")//输出：name is PersonA
        }

        for (name in studentList.withIndex()) {
            println("name is $name")//输出：name is StudentA
        }
        for (name in teacherList.withIndex()) {
            println("name is $name")//输出：name is TeacherA
        }

        person = student//正确，因为 Student 是 Person 的子类
        /*
        编译报错，类型不匹配：Required ArrayList<Person> Found ArrayList<Student>
        这是因为，虽然 Student 是 Person 的子类，但是 ArrayList<Student> 并不是 ArrayList<Person> 的子类
         */
        personList = studentList//错误
    }
```
* 对于上面的编译错误可以使用 协变注解修饰符 out 进行类型修饰。 协变类型参数 out 相当于java中的ArrayList<? extends C>；协变类型参数只能用作输出，可以作为返回值类型，但是无法作为入参的类型
```
    fun main() {
        var person = Person("PersonA")
        var personList: ArrayList<out Person> = arrayListOf(person)//使用 out 修饰符，限定类型上限

        var student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        personList = studentList//编译正确，这是因为 ArrayList<out Person> 限定了子类的上限为 Person

        for (name in personList.withIndex()) {
            println("name is $name")//输出：name is StudentA
        }
    }
```
* in 修饰符,同样先看一个例子
```
    fun main() {
        var person = Person("PersonA")
        var personList: ArrayList<Person> = arrayListOf(person)

        var student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        var teacher = Teacher("TeacherA")
        var teacherList: ArrayList<Teacher> = arrayListOf(teacher)

        /*
        以下两种均报类型不匹配错误，
         */
        teacherList = personList//Required ArrayList<Teacher> Found ArrayList<Person>
        teacherList = studentList//Required ArrayList<Teacher> Found ArrayList<Student>
    }
```
* 对于上面的编译错误可以使用 协变注解修饰符 in 进行类型修饰。<in Class> 相当于 Java 中的 ArrayList<? super Class> ；in 修饰符使得一个类型参数逆变，逆变类型参数只能用作输入，可以作为入参的类型，但是无法作为返回值的类型；
```
    fun main3() {
        val person = Person("PersonA")
        val personList: ArrayList<Person> = arrayListOf(person)

        val student = Student("StudentA")
        val studentList: ArrayList<Student> = arrayListOf(student)

        val teacher = Teacher("TeacherA")
        var teacherList: ArrayList<in Teacher> = arrayListOf(teacher)// <in Teacher> 就是允许 Teacher 的超类类型下限为 Teacher

        for (name in teacherList.withIndex()) {
            println("name is $name")//输出：name is TeacherA
        }

        teacherList = personList
        for (name in teacherList.withIndex()) {
            println("name is $name")//输出：name is PersonA
        }

        teacherList = studentList
        for (name in teacherList.withIndex()) {
            println("name is $name")//输出：name is StudentA
        }
    }
```
* 再来理解消费者 in 只能用作输入和 生产者 out 只能用作输出的概念：
> 不使用 in 和 out 修饰时
```
     open class Person(name: String) {
            var myName = "Siberiadante"
        }
     class Student(name: String) : Person("PersonA")

    fun main() {
        val person = Person("PersonA")
        var personList: ArrayList<Person> = arrayListOf(person)

        val student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        personList.add(student)//set 设置值,编译通过
        personList[0].myName// get 取值,编译通过
    }
```
> 作为 < out T>的类型，由于所有类型均为T的下限，无法得知其确定的类型，所以不能使用 set 方法，只能 get
```
    fun main() {
        val person = Person("PersonA")
        var personList: ArrayList<out Person> = arrayListOf(person)

        val student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)
        /*
        prohibits(禁止) use of public open fun add(element:E) !
         */
        personList.add(student)// set 设置值，编译不通过
        personList[0].myName// get 取值，编译通过
    }
```
> 作为 < in T>的类型
```
    fun main() {
        val person = Person("PersonA")
        var personList: ArrayList<in Person> = arrayListOf(person)

        val student = Student("StudentA")
        var studentList: ArrayList<Student> = arrayListOf(student)

        personList.add(student)//set 设置值,编译通过
        /*
        Unresolved reference : name,
         */
        personList[0].myName// get 取值,编译不通过
    }
```

### 星投射
* 在我们不知道类型参数的任何信息的情况下, 仍然希望能够安全地使用它时，就可以使用类型投射
```
    var list:ArrayList<*> = arrayListOf(100)
```
```
    fun main() {
        val person = Person("PersonA")

        val student = Student("StudentA")
        val studentList: ArrayList<Student> = arrayListOf(student)

        /*
        相当于  var personList: ArrayList<out Person> = studentList
         */
        var personList: ArrayList<*> = studentList
    }
```
```
    fun main9() {
        val person = Person("PersonA")
        val personList: ArrayList< Person> =arrayListOf(person)

        val student = Student("StudentA")

        /*
        相当于 val studentList:ArrayList<in Student> =personList
         */
        val studentList:ArrayList<*> =personList
    }
```

