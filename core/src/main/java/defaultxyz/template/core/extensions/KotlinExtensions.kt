package defaultxyz.template.core.extensions

fun <A, B> Pair<A?, B?>.toNotNullPair(): Pair<A, B>? =
    first?.let { a -> second?.let { b -> a to b } }

fun <T> List<T>.sameOrderBy(list2: List<T>, comparator: (T, T) -> Boolean): Boolean =
    zip(list2).all { (i1, i2) -> comparator(i1, i2) }

inline fun <reified T> Any.applyOnType(block: T.() -> Unit) =
    (this as? T)?.apply(block)