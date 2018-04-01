# BoilerplateKKMVP

Welcome to my boilerplate Android project. Firstly, why I named it KKMVP?

<b>K</b>otlin

<b>K</b>oin

<b>M</b>odel<b>V</b>iew<b>P</b>resenter

Repository contains branches:
- `addon/RestApi` simple example and logic for using REST api.
- `addon/BaseViews` simple classes (such as adapters) for reducing boilerplate code
- `addon/AndroidWear` simple boilerplate for standalone Android Wear app
- `addon/Realm` simple example of using Realm DB
- `addon/Room` simple example of using Room DB

You can easily merge it into `master`.

# Technologies and patterns used
- MVP with contracts
- 100% Kotlin
- Retrofit2 and OkHttp `addon/RestApi`
- RxJava2
- Koin (DI)
- Support libraries
- Picasso
- PaperParcel
- Calligraphy
- Realm `addon/Realm`
- Room `addon/Room`
- Android O support

# MVP with contracts
This pattern allow us to easy hermetization beetween Views and Presenters.
```
interface ExampleContract{
    interface IView: MvpView{
        fun showDataFromRest(value: String)
    }
    interface IPresenter<in T:MvpView>: Presenter<T>{
        fun getDataFromRest("time please")
    }
}
```
Interface `IView` should be implement by inheritance `BaseActivity` or `BaseFragment` class. This solution forces us to attach and detach presenter object in proper moment of `Activity` of `Fragment` lifecycle.
```
interface BasePresenterHandle{
     fun attachPresenter()
     fun detachPresenter()
}
```

Interface `IPresenter` should be implement by inheritance `BasePresenter` class. `BasePresenter` contains `subscriptions` variable (`CompositeDisposable`), every RxJava's Disposable should be add to it (preventing memory leaks).

Every `Presenter's` interface should be bind to implmentation by factory in `mvpModule` file.
```
...
    factory { ApiPresenter(get()) }     bind ApiContract.IPresenter::class
...
```
then, presenter in `IView` implementation should be injected this way:
```
    private val presenter by inject<ExContract.IPresenter<ExContract.IView>>()
    
    override fun attachPresenter() {
        presenter.attachView(this)
    }

    override fun detachPresenter() {
        presenter.detachView()
    }
```

See `com.shhatrat.boilerplate_kkmvp.ui.ex` for more details and example.

# How-to
- clone this repository
- in `app/build.gradle` change `applicationId` to your package
- in `strings.xml` change `app_name`
- change `Boilerplate.kt`class name to other
- change `com.shhatrat.boilerplate_kkmbp` package to your package
- remove `.git` files and directories

# TODO
- example `example/pollutionApp`
