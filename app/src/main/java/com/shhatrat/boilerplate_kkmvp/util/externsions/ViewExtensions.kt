package com.shhatrat.boilerplate_kkmvp.util.externsions

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.shhatrat.boilerplate_kkmvp.R

/**
 * Created by szymon on 20/01/18.
 */
fun View.simpleVisibility(b: Boolean){
    if(b)
        this.visibility = View.VISIBLE
    else
        this.visibility = View.INVISIBLE
}

fun RecyclerView.prepareSimple(context: Context){
    this.layoutManager = LinearLayoutManager(context)
    this.hasFixedSize()
    val divider = DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL)
    val dividerDrawable = ContextCompat.getDrawable(this.context, R.drawable.divider)
    if(dividerDrawable!=null)
        divider.setDrawable(dividerDrawable)
    this.addItemDecoration(divider)
}