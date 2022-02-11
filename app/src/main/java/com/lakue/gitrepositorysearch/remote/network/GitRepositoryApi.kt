package com.lakue.gitrepositorysearch.remote.network

import com.lakue.gitrepositorysearch.remote.model.ResponseGitRepository
import retrofit2.http.GET
import retrofit2.http.Query

interface GitRepositoryApi {

    @GET("/search/repositories")
    suspend fun getGitRepository(
        @Query("q") keyword: String,
        @Query("page") page: Int
    ): ResponseGitRepository

}