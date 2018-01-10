package com.shhatrat.boilerplate_kkmvp.util.externsions

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity

/**
 * Created by szymon on 10/01/18.
 */
inline fun <reified T: Fragment> FragmentActivity.replace(id: Int){
    this.supportFragmentManager.beginTransaction().replace(id, T::class.java.newInstance()).commit()
}