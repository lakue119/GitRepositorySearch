package com.lakue.gitrepositorysearch.ui.base

import com.lakue.gitrepositorysearch.base.BaseViewHolder
import com.lakue.gitrepositorysearch.base.BaseViewModel
import com.lakue.gitrepositorysearch.databinding.ItemEmptyBinding
import com.lakue.gitrepositorysearch.listener.AdapterListener
import com.lakue.gitrepositorysearch.remote.model.base.Model
import com.lakue.gitrepositorysearch.utils.provider.ResourcesProvider


class EmptyViewHolder (
    private val binding: ItemEmptyBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
): BaseViewHolder<Model>(binding, viewModel, resourcesProvider) {

    override fun reset() = with(binding) {
    }

    override fun bindData(model: Model) {
        super.bindData(model)
    }

    override fun bindViews(model: Model, adapterListener: AdapterListener) = with(binding) {

    }

}
