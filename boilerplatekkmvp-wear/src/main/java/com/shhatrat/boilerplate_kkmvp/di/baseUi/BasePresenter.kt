package com.shhatrat.boilerplate_kkmvp.di.baseUi

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by szymon on 23/12/17.
 */
open class BasePresenter<T : MvpView> : Presenter<T> {

    val subscriptions = CompositeDisposable()

    private var _view: T? = null
    val view: T
        get() { return _view ?: throw MvpViewNotAttachedException() }

    override fun attachView(view: T) {
        _view = view
        subscriptions.clear()
    }

    override fun detachView() {
        _view = null
        subscriptions.clear()
    }

    class MvpViewNotAttachedException : RuntimeException(
            "Please call Presenter.attachView(MvpView) before requesting data to the Presenter")
}
