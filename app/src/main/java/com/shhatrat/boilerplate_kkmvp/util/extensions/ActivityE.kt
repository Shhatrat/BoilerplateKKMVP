package com.shhatrat.boilerplate_kkmvp.util.extensions

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.View
import org.jetbrains.anko.internals.AnkoInternals
import org.jetbrains.anko.startActivity

inline fun <reified T: Activity> Activity.startActivityAndFinish(vararg params: Pair<String, Any>){
    this.startActivity<T>()
    finish()
}


fun Activity.restartApp(){
    val i = baseContext.packageManager
            .getLaunchIntentForPackage(baseContext.packageName)
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    startActivity(i)
}

inline fun <reified T: Activity> Activity.restartTo(){
    val i = Intent(this, T::class.java)
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    startActivity(i)
}

fun Activity.finishWithResultOk(){
    val returnIntent = Intent()
    this.setResult(Activity.RESULT_OK, returnIntent)
    this.finish()
}

fun Activity.finishWithResultCanceled(){
    val returnIntent = Intent()
    this.setResult(Activity.RESULT_CANCELED, returnIntent)
    this.finish()
}

inline fun <reified T: Activity> Activity.finishWithResultOk(vararg params: Pair<String, Any>){
    val re = AnkoInternals.createIntent(this, T::class.java , params)
    this.setResult(Activity.RESULT_OK, re)
    this.finish()
}

inline fun <reified T: Activity> Activity.startActivityForResultWithTransitions(requestCode : Int, vararg params: Pair<String, Any>){
    val re = AnkoInternals.createIntent(this, T::class.java , params.filter { it.second !is View }.toTypedArray())
    re.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
    val transformationParams = params.filter { it.second is View }.map { android.util.Pair(it.second as View, it.first) }.toTypedArray()
    val options = ActivityOptions.makeSceneTransitionAnimation(this,   *transformationParams)
    startActivityForResult(re, requestCode , options.toBundle())
}

inline fun <reified T: Activity> Activity.startActivityWithTransitions(vararg params: Pair<String, Any>){
    val re = AnkoInternals.createIntent(this, T::class.java , params.filter { it.second !is View }.toTypedArray())
    val transformationParams = params.filter { it.second is View }.map { android.util.Pair(it.second as View, it.first) }.toTypedArray()
    val options = ActivityOptions.makeSceneTransitionAnimation(this,   *transformationParams)
    startActivity(re , options.toBundle())
}

inline fun <reified T: Activity> Activity.startActivityWithTransitionsAndFinish(vararg params: Pair<String, Any>){
    val re = AnkoInternals.createIntent(this, T::class.java , params.filter { it.second !is View }.toTypedArray())
    val transformationParams = params.filter { it.second is View }.map { android.util.Pair(it.second as View, it.first) }.toTypedArray()
    val options = ActivityOptions.makeSceneTransitionAnimation(this,   *transformationParams)
    startActivity(re , options.toBundle())
    finish()
}