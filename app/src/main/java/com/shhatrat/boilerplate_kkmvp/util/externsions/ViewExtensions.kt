package com.shhatrat.boilerplate_kkmvp.util.externsions

import android.view.View

/**
 * Created by szymon on 20/01/18.
 */
fun View.simpleVisibility(b: Boolean){
    if(b)
        this.visibility = View.VISIBLE
    else
        this.visibility = View.INVISIBLE
}