package defaultxyz.template.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import defaultxyz.template.core.logging.error
import io.reactivex.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    /*
    Activity Callback support
     */

    val error: LiveData<Throwable> = MutableLiveData<Throwable>()

    /*
    Composite Disposable support
     */

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
    }

    private fun Disposable.addToDisposables() = compositeDisposable.add(this)

    /*
    LiveData support
     */

    protected fun <T> LiveData<T>.postValue(value: T?) {
        (this as? MutableLiveData<T>)?.postValue(value)
    }

    /*
    RxJava support
     */

    protected fun <T : Any> Observable<T>.subscribed(
        onError: (Throwable) -> Unit = {},
        onNext: (T) -> Unit
    ) {
        subscribe(onNext, {
            error(it)
            error.postValue(it)
            onError(it)
        }).addToDisposables()
    }

    protected fun <T : Any> Flowable<T>.subscribed(
        onError: (Throwable) -> Unit = {},
        onNext: (T) -> Unit
    ) {
        subscribe(onNext, {
            error(it)
            error.postValue(it)
            onError(it)
        }).addToDisposables()
    }

    protected fun <T : Any> Single<T>.subscribed(
        onError: (Throwable) -> Unit = {},
        onSuccess: (T) -> Unit
    ) {
        subscribe(onSuccess, {
            error(it)
            error.postValue(it)
            onError(it)
        }).addToDisposables()
    }

    protected fun <T : Any> Maybe<T>.subscribed(
        onError: (Throwable) -> Unit = {},
        onSuccess: (T) -> Unit
    ) {
        subscribe(onSuccess, {
            error(it)
            error.postValue(it)
            onError(it)
        }).addToDisposables()
    }

    protected fun Completable.subscribed(
        onError: (Throwable) -> Unit = {},
        onComplete: () -> Unit
    ) {
        subscribe(onComplete, {
            error(it)
            error.postValue(it)
            onError(it)
        }).addToDisposables()
    }

}