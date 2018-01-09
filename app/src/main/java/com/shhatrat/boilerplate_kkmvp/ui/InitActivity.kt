package com.shhatrat.boilerplate_kkmvp.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shhatrat.boilerplate_kkmvp.ui.main.MainActivity
import org.jetbrains.anko.startActivity


class InitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity<MainActivity>()
    }
}
