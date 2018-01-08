package com.shhatrat.boilerplate_kkmvp.util.externsions

import android.content.Context
import com.squareup.picasso.Picasso

/**
 * Created by szymon on 24/12/17.
 */
val Context.picasso: Picasso
    get() = Picasso.with(this)