package com.lakue.gitrepositorysearch.remote.network

data class ErrorResponse(
    val documentation_url: String,
    val errors: List<Error>,
    val message: String
){
    data class Error(
        val code: String,
        val `field`: String,
        val resource: String
    )
}