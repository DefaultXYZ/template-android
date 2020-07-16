package defaultxyz.template.core.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import defaultxyz.template.core.extensions.layoutInflater

abstract class BaseRecyclerAdapter<T : Any, B : ViewDataBinding> :
    RecyclerView.Adapter<BaseRecyclerAdapter<T, B>.ItemViewHolder>(),
    OnAdapterItemClickListener.Dispatcher<T> by OnAdapterItemClickListener.DispatcherImpl<T>() {

    abstract fun onBind(binding: B, item: T)
    abstract fun inflate(inflater: LayoutInflater, parent: ViewGroup): B

    var owner: RecyclerView? = null

    var items: List<T> = emptyList()
        set(value) {
            val state = owner?.layoutManager?.onSaveInstanceState()
            val result = DiffUtil.calculateDiff(ItemDiffCallback(field, value))
            field = value
            notifyDataSetChanged()
            result.dispatchUpdatesTo(this)
            state?.let { owner?.layoutManager?.onRestoreInstanceState(it) }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            inflate(parent.layoutInflater(), parent)
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    open fun compareItems(oldItem: T?, newItem: T?): Boolean = oldItem == newItem

    open fun onClear() = Unit

    inner class ItemViewHolder(
        private val binding: B
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: T) {
            onBind(binding, item)
            binding.root.setOnClickListener {
                dispatch(item)
            }
            binding.executePendingBindings()
        }
    }

    inner class ItemDiffCallback(
        private val oldItems: List<T>,
        private val newItems: List<T>
    ) : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            compareItems(
                oldItems.getOrNull(oldItemPosition),
                newItems.getOrNull(newItemPosition)
            )

        override fun getOldListSize(): Int = oldItems.size

        override fun getNewListSize(): Int = newItems.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldItems.getOrNull(oldItemPosition) == newItems.getOrNull(newItemPosition)
    }

}