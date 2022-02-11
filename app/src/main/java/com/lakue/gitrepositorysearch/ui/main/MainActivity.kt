package com.lakue.gitrepositorysearch.ui.main

import android.os.Bundle
import android.util.Log
import com.lakue.gitrepositorysearch.R
import com.lakue.gitrepositorysearch.base.BaseActivity
import com.lakue.gitrepositorysearch.databinding.ActivityMainBinding
import com.lakue.gitrepositorysearch.ext.logI
import com.lakue.gitrepositorysearch.ext.showToast
import com.lakue.gitrepositorysearch.remote.model.Item
import com.lakue.gitrepositorysearch.remote.model.ResponseGitRepository
import com.lakue.gitrepositorysearch.utils.provider.DefaultResourcesProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main){

    val TAG = MainActivity::class.java.name

    private var page = 1

    val adapterListsnser = object : RepositoryListListener {
        override fun onClickItem(model: Item) {
            showToast(model.full_name)
        }
    }

    val resourcesProvider by lazy {
        DefaultResourcesProvider(
            this
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchGitRepository()

        setObserver()
    }

    private fun setObserver(){
        viewModel.apply{
            liveSuccess.observe(this@MainActivity){ response ->
                val data = response as ResponseGitRepository
                logI(TAG, data.toString())
                viewModel.addRepositoryItems(data.items)
            }
        }
    }

    fun onSearchClick(){
        viewModel.itemClear()
        viewModel.fetchGitRepository()
    }
}