package com.shhatrat.boilerplate_kkmvp.util.extensions

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.transition.Transition
import androidx.transition.TransitionManager
import com.squareup.picasso.RequestCreator
import java.io.File

fun TextView.textString() = this.text.toString()

val TextView.textIntOrZero: Int?
    get(){
        try{
            return this.text.toString().toInt()
        }
        catch(e : Throwable){
            return null
        }
    }

fun View.visible(){
    this.visibility = View.VISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}

fun View.invisible(){
    this.visibility = View.INVISIBLE
}

inline fun TextView.textRes(textRes: Int){
    text = context.getString(textRes)
}


fun ImageView.load(path: String, request: (RequestCreator) -> RequestCreator) {
    request(context.picasso.load(path)).into(this)
}

fun ImageView.load(file : File, request: (RequestCreator) -> RequestCreator) {
    request(context.picasso.load(file)).into(this)
}

fun ImageView.load(res: Int?){
    this.setImageDrawable(res?.let { ContextCompat.getDrawable(this.context, it) })
}

//  TRANSITIONS

fun ViewGroup.transitionShow(transition : Transition){
    TransitionManager.beginDelayedTransition(this, transition)
    this.visible()
}

fun ViewGroup.transitionHide(transition : Transition){
    TransitionManager.beginDelayedTransition(this, transition)
    this.invisible()
}