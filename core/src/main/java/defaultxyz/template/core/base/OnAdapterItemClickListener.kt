package defaultxyz.template.core.base

interface OnAdapterItemClickListener<T : Any> {
    fun onItemClick(item: T)

    interface Dispatcher<T : Any> {
        var listener: OnAdapterItemClickListener<T>?
        fun setOnItemClickListener(listener: (T) -> Unit)
        fun setOnItemClickListener(listener: OnAdapterItemClickListener<T>)
        fun removeOnItemClickListener()
        fun dispatch(item: T)
    }

    class DispatcherImpl<T : Any> : Dispatcher<T> {
        override var listener: OnAdapterItemClickListener<T>? = null

        override fun setOnItemClickListener(listener: (T) -> Unit) {
            this.listener = object : OnAdapterItemClickListener<T> {
                override fun onItemClick(item: T) {
                    listener(item)
                }
            }
        }

        override fun setOnItemClickListener(listener: OnAdapterItemClickListener<T>) {
            this.listener = listener
        }

        override fun removeOnItemClickListener() {
            listener = null
        }

        override fun dispatch(item: T) {
            listener?.onItemClick(item)
        }
    }
}