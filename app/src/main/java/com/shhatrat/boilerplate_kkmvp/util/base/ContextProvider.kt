package com.shhatrat.boilerplate_kkmvp.util.base

import android.content.Context

abstract class ContextProvider {

    companion object {
        lateinit var context: Context
        /**
         * Initialize PrefDelegate with a Context reference.
         *
         * **This method needs to be called before any other usage of PrefDelegate!!**
         */
        fun init(context: Context) {
            Companion.context = context
        }
    }
}