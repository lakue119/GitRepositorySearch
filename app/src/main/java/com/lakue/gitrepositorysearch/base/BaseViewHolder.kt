package com.lakue.gitrepositorysearch.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.lakue.gitrepositorysearch.listener.AdapterListener
import com.lakue.gitrepositorysearch.remote.model.base.Model
import com.lakue.gitrepositorysearch.utils.provider.ResourcesProvider

abstract class BaseViewHolder<M: Model>(
    binding: ViewBinding,
    protected val viewModel: BaseViewModel,
    protected val resourcesProvider: ResourcesProvider
) : RecyclerView.ViewHolder(binding.root) {

    abstract fun reset()

    open fun bindData(model: M) {
        reset()
    }

    abstract fun bindViews(model: M, adapterListener: AdapterListener)

}
