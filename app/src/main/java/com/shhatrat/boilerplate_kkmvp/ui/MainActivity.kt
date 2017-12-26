package com.shhatrat.boilerplate_kkmvp.ui

//import com.betomaluje.android.kyky.Kyky
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.wearable.DataClient
import com.google.android.gms.wearable.PutDataMapRequest
import com.patloew.rxwear.RxWear
import com.shhatrat.boilerplate_kkmvp.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {

    private val COUNT_KEY = "com.example.key.count"
    private val mDataClient: DataClient? = null
    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rxWear = RxWear(this)

        button3.setOnClickListener {
            rxWear.message().sendDataMapToAllRemoteNodes("/dataMap")
                    .putString("title", "Title")
                    .putString("message", "My message")
                    .toObservable()
                    .subscribe({ requestId ->
                        toast("heeh $requestId")
                    },
                            {toast(it.message?:"blad")}
                    )
        }
    }

    private fun increaseCounter() {
        val putDataMapReq = PutDataMapRequest.create("/count")
        putDataMapReq.dataMap.putInt(COUNT_KEY, count++)
        val putDataReq = putDataMapReq.asPutDataRequest()
        val putDataTask = mDataClient?.putDataItem(putDataReq)
        putDataTask?.addOnSuccessListener { toast("ok") }
    }
}
