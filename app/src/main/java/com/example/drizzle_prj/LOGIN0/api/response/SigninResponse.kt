package com.example.drizzle_prj.LOGIN0.api.response

data class SigninResponse (
    val token: String, val refreshToken: String,
    val userName: String,
    val userId: Long
)