package com.shhatrat.boilerplate_kkmvp

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import pl.tajchert.buswear.EventBus


class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        EventBus.getDefault(this).register(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMyOtherEvent(textd: String) {
        Log.d("sssss", textd)
        text.text = textd
    }
}
