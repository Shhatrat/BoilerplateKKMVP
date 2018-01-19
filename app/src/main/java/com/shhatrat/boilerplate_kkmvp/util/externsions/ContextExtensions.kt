package com.shhatrat.boilerplate_kkmvp.util.externsions

import android.app.Activity
import android.app.Service
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import com.shhatrat.boilerplate_kkmvp.service.MainService
import com.squareup.picasso.Picasso
import org.jetbrains.anko.internals.AnkoInternals
import org.jetbrains.anko.internals.AnkoInternals.createIntent

/**
 * Created by szymon on 24/12/17.
 */
val Context.picasso: Picasso
    get() = Picasso.with(this)

inline fun <reified T: Activity, R: Enum<*>> Context.startActivity(vararg enumParams: Pair<R, Any?>){
    val params = enumParams.map { Pair(it.first.name,it.second) }.toTypedArray()
    return         AnkoInternals.internalStartActivity(this, T::class.java, params)
}

@RequiresApi(Build.VERSION_CODES.O)
inline fun <reified T: Service> Context.startForegroundService(vararg params: Pair<String, Any?>)=
this.startForegroundService(createIntent(this, T::class.java, params))


inline fun <reified T: Service> Context.startService(vararg params: Pair<String, Any?>){
        if(params.contains(Pair(MainService.foreground, true)))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService<T>(MainService.foreground to true)
            }else
    AnkoInternals.internalStartService(this, T::class.java, params)
}