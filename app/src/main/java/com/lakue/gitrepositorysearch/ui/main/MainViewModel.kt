package com.lakue.gitrepositorysearch.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lakue.gitrepositorysearch.base.BaseViewModel
import com.lakue.gitrepositorysearch.remote.model.Item
import com.lakue.gitrepositorysearch.remote.model.base.CellType
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

    //빈값일때 뭐가나올까? 로그찍어보기.
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

    fun addRepositoryItems(items: List<Item>){
        if(repositoryItems.isNotEmpty() && repositoryItems.last().type == CellType.LOADING_CELL){
            repositoryItems.removeAt(repositoryItems.lastIndex)
        }
        repositoryItems.addAll(items)
        if(repositoryItems.isEmpty()){
            //데이터 없을 때 처리
            repositoryItems.add(Item(type = CellType.EMPTY_CELL))
        } else {
            //마지막데이터 로딩바 생성
            repositoryItems.add(Item(type = CellType.LOADING_CELL))
        }
        _liveRepositoryItems.value = repositoryItems
    }

    fun itemClear(){
        page = 0
        repositoryItems.clear()
        _liveRepositoryItems.value = repositoryItems
    }

}