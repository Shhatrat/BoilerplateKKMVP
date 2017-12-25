package com.shhatrat.boilerplate_kkmvp.ui

//import com.betomaluje.android.kyky.Kyky
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shhatrat.boilerplate_kkmvp.R
import kotlinx.android.synthetic.main.activity_main.*
import pl.tajchert.buswear.EventBus


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button3.setOnClickListener {
            EventBus.getDefault(this).postRemote("fromMobile")
        }
    }
}
