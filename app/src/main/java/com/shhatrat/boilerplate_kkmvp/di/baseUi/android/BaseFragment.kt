package com.shhatrat.boilerplate_kkmvp.di.baseUi.android

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.shhatrat.boilerplate_kkmvp.Boilerplate
import org.jetbrains.anko.toast

/**
 * Created by szymon on 23/12/17.
 */
abstract class BaseFragment: Fragment(), BasePresenterHandle{

    companion object {
        var intentKey: String = Boilerplate.NORMAL
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intentKey = arguments?.getString(Boilerplate.INJECT_KEY)?:Boilerplate.NORMAL
        attachPresenter()
    }

    override fun getContext(): Context {
        return activity?.baseContext!!
    }

    fun showError(msg: String){
        activity?.toast(msg)
    }

    override fun onDestroy() {
        super.onDestroy()
        detachPresenter()
    }

}