package com.siberiadante.kotlinforandroid.kotlin.demop9

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/29
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
enum class EnumDemo92 : ItemClickListener {
    BUTTON {
        override fun onClick(msg: String) {
            print(msg)
        }
    },
    IMAGE {
        override fun onClick(msg: String) {
            print(msg)
        }
    }
}