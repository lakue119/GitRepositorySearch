package com.lakue.gitrepositorysearch.remote.model

import com.lakue.gitrepositorysearch.remote.model.base.Model

data class ResponseGitRepository(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)