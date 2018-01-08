package com.shhatrat.boilerplate_kkmvp.ui

//import com.betomaluje.android.kyky.Kyky
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.ui.wear.WearActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button3.setOnClickListener {
            startActivity<WearActivity>()
        }
    }
}
