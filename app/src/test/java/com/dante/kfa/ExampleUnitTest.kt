package com.dante.kfa

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        val ints = intArrayOf(11, 2, 4, 6, 2, 9, 5, 7)
        val i = 10
        if (i !in 1..10) {
            print(i)
        } else {
            print("not in")
        }
        for (i in 5 downTo 1) {
            print(i)//输出结果：54321
        }
        for (i in ints.indices) {
            print("$i value-${ints[i]}---")
        }
    }
}
