package com.shhatrat.boilerplate_kkmvp.util.extensions

fun Double.twoPlaces() = "%.2f".format(this)

fun <E> Iterable<E>.updated(index: Int, elem: E) = mapIndexed { i, existing ->  if (i == index) elem else existing }