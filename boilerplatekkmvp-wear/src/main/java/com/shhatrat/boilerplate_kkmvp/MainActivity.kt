package com.shhatrat.boilerplate_kkmvp

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import com.google.android.gms.wearable.DataClient
import com.google.android.gms.wearable.DataEventBuffer
import com.google.android.gms.wearable.MessageApi
import com.patloew.rxwear.RxWear
import com.patloew.rxwear.transformers.MessageEventGetDataMap


class MainActivity : WearableActivity(), DataClient.OnDataChangedListener {
    override fun onDataChanged(p0: DataEventBuffer) {
        p0.forEach {
            Log.d("ddddd", it.dataItem.uri.path)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        val rxWear = RxWear(this)

        rxWear.message().listen("/dataMap", MessageApi.FILTER_LITERAL)
                .compose(MessageEventGetDataMap.noFilter())
                .subscribe { dataMap ->
                    val title = dataMap.getString("title", "NIE MA")
                    val message = dataMap.getString("message", "NIE MA INFO")
                    /* do something */
                    Log.d("ddddddddd", "$title $message")
                }
    }


}
