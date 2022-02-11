package com.lakue.gitrepositorysearch.remote.impl

import com.lakue.gitrepositorysearch.remote.model.ResponseGitRepository
import com.lakue.gitrepositorysearch.remote.network.GitRepositoryApi
import com.lakue.gitrepositorysearch.remote.network.ResultWrapper
import com.lakue.gitrepositorysearch.repository.GitRepositoryRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import javax.inject.Singleton

class GitRepositoryRemoteDataSourceImpl @Inject constructor(
    private val gitRepositoryApi: GitRepositoryApi
): DataSourceImpl(), GitRepositoryRemoteDataSource {
    val Tag = GitRepositoryRemoteDataSourceImpl::class.java.name

    override suspend fun getGitRepository(search: String): ResultWrapper<ResponseGitRepository> {
        return safeApiCall(Dispatchers.IO) {
            gitRepositoryApi.getPocketInfo(search)
        }
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class GitRepositoryRemoteDataSourceModule {

    @Binds
    @Singleton
    abstract fun bindGitRepositoryRemoteDataSource(gitRepositoryRemoteDataSourceImpl: GitRepositoryRemoteDataSourceImpl): GitRepositoryRemoteDataSource

}
