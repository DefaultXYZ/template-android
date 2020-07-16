package defaultxyz.template.core.base

import androidx.recyclerview.widget.RecyclerView

interface HasRecyclerList {
    val recyclerView: RecyclerView
    val adapter: BaseRecyclerAdapter<*, *>
}