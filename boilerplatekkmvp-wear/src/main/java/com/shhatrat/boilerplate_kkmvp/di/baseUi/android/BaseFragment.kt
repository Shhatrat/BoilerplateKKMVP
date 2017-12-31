package com.shhatrat.boilerplate_kkmvp.di.baseUi.android

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 * Created by szymon on 23/12/17.
 */
abstract class BaseFragment: Fragment(), BasePresenterHandle{

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()
        detachPresenter()
    }

}