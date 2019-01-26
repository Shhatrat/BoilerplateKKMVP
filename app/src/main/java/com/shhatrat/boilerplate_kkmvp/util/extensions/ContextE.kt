package com.shhatrat.boilerplate_kkmvp.util.extensions

import android.content.Context
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso

val Context.picasso: Picasso
    get() = Picasso.with(this)

fun Context.isPermissionGranted(permissionPackage: String) = ContextCompat.checkSelfPermission(this, permissionPackage) == PackageManager.PERMISSION_GRANTED