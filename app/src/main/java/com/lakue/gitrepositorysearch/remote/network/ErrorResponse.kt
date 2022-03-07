package com.lakue.gitrepositorysearch.remote.network

data class ErrorResponse(
    val documentation_url: String,
    val errors: List<Error>,
    val message: String
){
    data class Error(
        val code: String,
        //왜 이런식으로 만들어지는지 체크
        val `field`: String,
        val resource: String,
    )
}