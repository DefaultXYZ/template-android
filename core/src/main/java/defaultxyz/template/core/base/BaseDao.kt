package defaultxyz.template.core.base

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface BaseDao<T : Any> {
    fun insertAll(vararg entities: T): Completable

    fun getAll(): Single<List<T>>

    fun deleteAll(): Completable

    fun observeAll(): Observable<List<T>>
}