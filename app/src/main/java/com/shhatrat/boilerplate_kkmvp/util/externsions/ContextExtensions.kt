package com.shhatrat.boilerplate_kkmvp.util.externsions

import android.app.Activity
import android.content.Context
import com.squareup.picasso.Picasso
import org.jetbrains.anko.internals.AnkoInternals

/**
 * Created by szymon on 24/12/17.
 */
val Context.picasso: Picasso
    get() = Picasso.with(this)

inline fun <reified T: Activity, R: Enum<*>> Context.startActivity(vararg enumParams: Pair<R, Any?>){
    val params = enumParams.map { Pair(it.first.name,it.second) }.toTypedArray()
    return         AnkoInternals.internalStartActivity(this, T::class.java, params)
}