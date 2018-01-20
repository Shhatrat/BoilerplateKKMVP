package com.shhatrat.boilerplate_kkmvp.util.externsions

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import com.shhatrat.boilerplate_kkmvp.Boilerplate
import org.jetbrains.anko.bundleOf

/**
 * Created by szymon on 10/01/18.
 */
inline fun <reified T: Fragment> FragmentActivity.replace(id: Int, injectKey: String?){
    val fragment = T::class.java.newInstance()
    if(injectKey!=null)
        fragment.arguments = bundleOf(Boilerplate.INJECT_KEY to injectKey)
    this.supportFragmentManager.beginTransaction().replace(id, fragment).commit()
}