package com.lakue.gitrepositorysearch.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lakue.gitrepositorysearch.base.BaseViewModel
import com.lakue.gitrepositorysearch.remote.model.Item
import com.lakue.gitrepositorysearch.repository.GitRepositoryRemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mediaRepository:GitRepositoryRemoteDataSource
) : BaseViewModel(){

    val liveKeyword = MutableLiveData("")

    private val repositoryItems = ArrayList<Item>()
    private val _liveRepositoryItems = MutableLiveData<List<Item>>()
    val liveRepositoryItems: LiveData<List<Item>> = _liveRepositoryItems

    var page = 0

    fun fetchGitRepository(){
        viewModelScope.launch {
            val response = mediaRepository.getGitRepository(liveKeyword.value!!, page)
            page++
            responseValidation(response)
        }
    }

    fun addRepositoryItem(items: Item){
        repositoryItems.add(items)
        _liveRepositoryItems.value = repositoryItems
    }

    fun addRepositoryItems(items: List<Item>){
        repositoryItems.addAll(items)
        _liveRepositoryItems.value = repositoryItems
    }

    fun itemClear(){
        page = 0
        repositoryItems.clear()
        _liveRepositoryItems.value = repositoryItems
    }

}