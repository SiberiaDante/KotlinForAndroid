package com.dante.kfa

import android.app.Application
import cn.bingoogolapple.swipebacklayout.BGASwipeBackHelper
import com.dante.kfa.model.User
import com.dante.kfa.utils.UserInfoHelper
import kotlin.properties.Delegates

/**
 * create date: 2018/12/21
 */
class App : Application() {

    companion object {
        var instance: App by Delegates.notNull()        //实例用它
        var mAppContext: Application by Delegates.notNull()     //applicationContext用它
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        mAppContext = this
        UserInfoHelper.init(this)
    }


    var user: User? = null
        set(value) {
            field = value
            if (value != null) {
                UserInfoHelper.saveUser(value)
            } else {
                UserInfoHelper.clearUser()
            }
        }
        get() {
            if (field == null)
                field = UserInfoHelper.getUser()
            return field
        }

    var isLogin: Boolean = false
        get() {
            field = user != null
            return field
        }

}