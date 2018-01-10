package com.shhatrat.boilerplate_kkmvp.di.modules

import com.shhatrat.boilerplate_kkmvp.Boilerplate.Companion.fav
import com.shhatrat.boilerplate_kkmvp.Boilerplate.Companion.normal
import com.shhatrat.boilerplate_kkmvp.data.repository.SettingsRepositiory
import com.shhatrat.boilerplate_kkmvp.ui.list.fragment.FavPresenter
import com.shhatrat.boilerplate_kkmvp.ui.list.fragment.ListContract
import com.shhatrat.boilerplate_kkmvp.ui.list.fragment.ListFragment
import com.shhatrat.boilerplate_kkmvp.ui.list.fragment.ListPresenter
import com.shhatrat.boilerplate_kkmvp.ui.old.api.ApiContract
import com.shhatrat.boilerplate_kkmvp.ui.old.api.ApiPresenter
import com.shhatrat.boilerplate_kkmvp.ui.old.ex.ExContract
import com.shhatrat.boilerplate_kkmvp.ui.old.ex.ExPresenter
import com.shhatrat.boilerplate_kkmvp.ui.old.wear.WearContract
import com.shhatrat.boilerplate_kkmvp.ui.old.wear.WearPresenter
import com.shhatrat.boilerplate_kkmvp.ui.settings.SettingsContract
import com.shhatrat.boilerplate_kkmvp.ui.settings.SettingsPresenter
import org.koin.android.module.AndroidModule

/**
 * Created by szymon on 24/12/17.
 */
class MvpModule: AndroidModule(){
    override fun context() = applicationContext {
        provide { getRepo() }
        provide { WearPresenter(get()) } bind WearContract.IPresenter::class
        provide { ApiPresenter(get()) } bind ApiContract.IPresenter::class
        provide { ExPresenter( get()) } bind ExContract.IPresenter::class
        provide { SettingsPresenter( get(), get()) } bind SettingsContract.IPresenter::class
        provide(fav) { ListPresenter(get(), get()) } bind ListContract.IPresenter::class
        provide(normal) { FavPresenter(get(), get()) } bind ListContract.IPresenter::class
        provide { ListFragment() }
    }

    fun getRepo(): SettingsRepositiory {
        return SettingsRepositiory()
    }
}