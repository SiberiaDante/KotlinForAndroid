package com.dante.kfa

import org.jetbrains.annotations.TestOnly

/**
 * create date: 2018/12/20
 */
class TestMain {
    val msgs = mutableListOf<String>()
    fun testVoid(vararg name: Int) {
        msgs.add("sss")
        val length = msgs.size ?: -1
    }

    @TestOnly
    public fun testDemo() {
        val i = 1
        if (i in 1..10) {
            print(i)
        }
    }

}