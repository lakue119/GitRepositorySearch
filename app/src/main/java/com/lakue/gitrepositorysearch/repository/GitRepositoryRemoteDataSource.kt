package com.lakue.gitrepositorysearch.repository

import com.lakue.gitrepositorysearch.remote.model.ResponseGitRepository
import com.lakue.gitrepositorysearch.remote.network.ResultWrapper

interface GitRepositoryRemoteDataSource {
    suspend fun getGitRepository(search: String, page: Int): ResultWrapper<ResponseGitRepository>
}