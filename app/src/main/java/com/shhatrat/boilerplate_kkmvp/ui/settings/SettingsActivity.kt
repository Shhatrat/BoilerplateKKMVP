package com.shhatrat.boilerplate_kkmvp.ui.settings

import android.os.Bundle
import android.view.View
import com.shhatrat.boilerplate_kkmvp.R
import com.shhatrat.boilerplate_kkmvp.di.baseUi.android.BaseActivity
import com.shhatrat.boilerplate_kkmvp.service.MainService
import com.shhatrat.boilerplate_kkmvp.util.service.isRunning
import kotlinx.android.synthetic.main.activity_settings.*
import org.jetbrains.anko.startService
import org.jetbrains.anko.stopService
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class SettingsActivity : BaseActivity(), SettingsContract.IView {
    override fun startService() {
        stopService()
        startService<MainService>()
    }

    override fun stopService() {
        if(isRunning<MainService>())
            stopService<MainService>()
    }

    override fun startBackgroundService() {
        stopService()
        startService<MainService>(MainService.foreground to true)
    }

    private val presenter by inject<SettingsContract.IPresenter<SettingsContract.IView>>()

    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun detachPresenter() {
        presenter.detachView()
    }

    override fun showWear() {
        backgroudServiceSW.visibility = View.VISIBLE
        checkWearBtn.visibility = View.VISIBLE
    }

    override fun hideWear() {
        backgroudServiceSW.visibility = View.GONE
        checkWearBtn.visibility = View.GONE
    }

    override fun setView(enableWear: Boolean, enableService: Boolean, update: Boolean) {
        androidWearSW.isChecked = enableWear
        backgroudServiceSW.isChecked = enableService
        updateSW.isChecked = update
    }

    override fun showConnection(msg: String) {
        toast("Wear connection: $msg")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        presenter.getData()
        initListeners()
    }

    private fun initListeners(){
        androidWearSW.setOnCheckedChangeListener { _, isChecked ->  presenter.setWear(isChecked) }
        backgroudServiceSW.setOnCheckedChangeListener { _, isChecked ->  presenter.setService(isChecked) }
        updateSW.setOnCheckedChangeListener { _, isChecked ->  presenter.setUpdate(isChecked) }
        checkWearBtn.setOnClickListener { presenter.isWearConnected() }
    }
}
