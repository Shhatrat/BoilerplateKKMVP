package com.shhatrat.boilerplate_kkmvp.util.externsions

import android.widget.ImageView

/**
 * Created by szymon on 24/12/17.
 */
fun ImageView.load(path: String?) {
    (context.picasso.load(path)).fit().centerCrop().into(this)
}