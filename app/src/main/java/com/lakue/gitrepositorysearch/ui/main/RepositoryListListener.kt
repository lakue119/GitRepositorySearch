package com.lakue.gitrepositorysearch.ui.main

import com.lakue.gitrepositorysearch.listener.AdapterListener
import com.lakue.gitrepositorysearch.remote.model.Item


interface RepositoryListListener: AdapterListener {
    fun onClickItem(model: Item)
}
