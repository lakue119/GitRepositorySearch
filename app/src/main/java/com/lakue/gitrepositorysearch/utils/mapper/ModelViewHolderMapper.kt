package com.lakue.gitrepositorysearch.utils.mapper

import android.view.LayoutInflater
import android.view.ViewGroup
import com.lakue.gitrepositorysearch.base.BaseViewHolder
import com.lakue.gitrepositorysearch.base.BaseViewModel
import com.lakue.gitrepositorysearch.databinding.ItemEmptyBinding
import com.lakue.gitrepositorysearch.databinding.ItemLoadingBinding
import com.lakue.gitrepositorysearch.databinding.ItemRepositoryBinding
import com.lakue.gitrepositorysearch.remote.model.base.CellType
import com.lakue.gitrepositorysearch.remote.model.base.Model
import com.lakue.gitrepositorysearch.ui.base.EmptyViewHolder
import com.lakue.gitrepositorysearch.ui.base.LoadingViewHolder
import com.lakue.gitrepositorysearch.ui.main.MainViewHolder
import com.lakue.gitrepositorysearch.utils.provider.ResourcesProvider

object ModelViewHolderMapper {

    @Suppress("UNCHECKED_CAST")
    fun <M: Model> map(
        parent: ViewGroup,
        type: CellType,
        viewModel: BaseViewModel,
        resourcesProvider: ResourcesProvider
    ): BaseViewHolder<M> {
        val inflater = LayoutInflater.from(parent.context)
        val viewHolder = when (type) {
            CellType.EMPTY_CELL ->
                EmptyViewHolder(
                    ItemEmptyBinding.inflate(inflater, parent, false),
                    viewModel,
                    resourcesProvider
                )
            CellType.GIT_REPOSITORY_CELL ->
                MainViewHolder(
                    ItemRepositoryBinding.inflate(inflater, parent, false),
                    viewModel,
                    resourcesProvider
                )
            CellType.LOADING_CELL ->
                LoadingViewHolder(
                    ItemLoadingBinding.inflate(inflater, parent, false),
                    viewModel,
                    resourcesProvider
                )
            else -> {}
        }

        return viewHolder as BaseViewHolder<M>
    }

}
