package com.shhatrat.boilerplate_kkmvp.di.baseUi.android

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by szymon on 23/12/17.
 */
abstract class BaseActivity: AppCompatActivity(), BasePresenterHandle {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        attachPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachPresenter()
    }

    fun getContext() = this

    override fun onDestroy() {
        super.onDestroy()
        detachPresenter()
    }
}