package com.lakue.gitrepositorysearch.ui.main

import androidx.lifecycle.viewModelScope
import com.lakue.gitrepositorysearch.base.BaseViewModel
import com.lakue.gitrepositorysearch.repository.GitRepositoryRemoteDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mediaRepository:GitRepositoryRemoteDataSource
) : BaseViewModel(){

    fun fetchGitRepository(search: String){
        viewModelScope.launch {
            val response = mediaRepository.getGitRepository(search)
            responseValidation(response)
        }
    }
}