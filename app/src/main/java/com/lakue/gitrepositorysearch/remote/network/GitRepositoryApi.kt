package com.lakue.gitrepositorysearch.remote.network

import com.lakue.gitrepositorysearch.remote.model.ResponseGitRepository
import retrofit2.http.GET
import retrofit2.http.Query

interface GitRepositoryApi {

    @GET("/search/repositories")
    suspend fun getPocketInfo(
        @Query("q") keyword: String
    ): ResponseGitRepository

}