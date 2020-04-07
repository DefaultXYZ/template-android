package defaultxyz.template.core.rx

import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

data class RxOptional<T : Any>(
    val value: T?
)

fun <T : Any> T?.asOptional(): RxOptional<T> = RxOptional(this)

fun <T : Any> T?.asObservableOptional(): Observable<RxOptional<T>> =
    Observable.just(this.asOptional())

fun <T : Any> T?.asSingleOptional(): Single<RxOptional<T>> = Single.just(this.asOptional())

fun <T : Any> T?.asMaybeOptional(): Maybe<RxOptional<T>> = Maybe.just(this.asOptional())

fun <T : Any> T?.asFlowableOptional(): Flowable<RxOptional<T>> = Flowable.just(this.asOptional())

fun <T : Any> Observable<RxOptional<T>>.nonEmpty(): Observable<T> =
    flatMap { optional ->
        when (val value = optional.value) {
            null -> Observable.error<T>(IllegalArgumentException("Value in optional is nullable"))
            else -> Observable.just(value)
        }
    }

fun <T : Any> Single<RxOptional<T>>.nonEmpty(): Single<T> =
    flatMap { optional ->
        when (val value = optional.value) {
            null -> Single.error<T>(IllegalArgumentException("Value in optional is nullable"))
            else -> Single.just(value)
        }
    }

fun <T : Any> Maybe<RxOptional<T>>.nonEmpty(): Maybe<T> =
    flatMap { optional ->
        when (val value = optional.value) {
            null -> Maybe.error<T>(IllegalArgumentException("Value in optional is nullable"))
            else -> Maybe.just(value)
        }
    }

fun <T : Any> Flowable<RxOptional<T>>.nonEmpty(): Flowable<T> =
    flatMap { optional ->
        when (val value = optional.value) {
            null -> Flowable.error<T>(IllegalArgumentException("Value in optional is nullable"))
            else -> Flowable.just(value)
        }
    }