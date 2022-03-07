package com.lakue.gitrepositorysearch.ui.main

import android.os.Bundle
import android.util.Log
import com.lakue.gitrepositorysearch.R
import com.lakue.gitrepositorysearch.base.BaseActivity
import com.lakue.gitrepositorysearch.base.BaseAdapter
import com.lakue.gitrepositorysearch.databinding.ActivityMainBinding
import com.lakue.gitrepositorysearch.ext.logI
import com.lakue.gitrepositorysearch.ext.showToast
import com.lakue.gitrepositorysearch.remote.model.Item
import com.lakue.gitrepositorysearch.remote.model.ResponseGitRepository
import com.lakue.gitrepositorysearch.utils.LoadingDialog
import com.lakue.gitrepositorysearch.utils.provider.DefaultResourcesProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main){

    val TAG = MainActivity::class.java.name

    val rvBottomCatch: Function1<Int, Unit> = this::onBottomCatch

    private fun onBottomCatch(lastPosition: Int) {
        val adapter = binding.rvRepository.adapter
        if (adapter?.itemCount!! > 0 && !rvloading && lastPosition >= adapter.itemCount - 2) {
            getRepositoryList()
        } 
    }

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
        setObserver()
    }

    private fun setObserver(){
        viewModel.apply{
            liveSuccess.observe(this@MainActivity){ response ->
                LoadingDialog.hideLoading(this@MainActivity)
                rvloading = false
                (response as ResponseGitRepository).apply{
                    logI(TAG, this.toString())
                    if(this.items.isEmpty()){
                        isLastPage = true
                    }
                    viewModel.addRepositoryItems(this.items)
                }

            }
        }
    }

    fun onSearchClick(){
        LoadingDialog.showLoading(this)
        rvItemClear()
        getRepositoryList()
    }

    private fun rvItemClear(){
        viewModel.itemClear()
        isLastPage = false
        binding.apply{
            llBackground.clearFocus()
            (rvRepository.adapter as? BaseAdapter<*,*>)?.clear()
        }
    }

    private fun getRepositoryList(){
        if(!isLastPage){
            rvloading = true
            viewModel.fetchGitRepository()
        }
    }

}