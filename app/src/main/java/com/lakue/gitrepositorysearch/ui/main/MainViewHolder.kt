package com.lakue.gitrepositorysearch.ui.main

import com.lakue.gitrepositorysearch.base.BaseViewHolder
import com.lakue.gitrepositorysearch.base.BaseViewModel
import com.lakue.gitrepositorysearch.databinding.ItemRepositoryBinding
import com.lakue.gitrepositorysearch.listener.AdapterListener
import com.lakue.gitrepositorysearch.remote.model.Item
import com.lakue.gitrepositorysearch.utils.provider.ResourcesProvider


class MainViewHolder (
    private val binding: ItemRepositoryBinding,
    viewModel: BaseViewModel,
    resourcesProvider: ResourcesProvider
): BaseViewHolder<Item>(binding, viewModel, resourcesProvider) {

    override fun reset() = with(binding) {
    }

    override fun bindData(model: Item) {
        super.bindData(model)
        with(binding) {
            item = model
        }
    }

    override fun bindViews(model: Item, adapterListener: AdapterListener) = with(binding) {
        if (adapterListener is RepositoryListListener) {
            root.setOnClickListener {
                adapterListener.onClickItem(model)
            }
        }
    }

}
