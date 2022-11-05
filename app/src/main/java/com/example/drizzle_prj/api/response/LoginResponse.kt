package com.example.drizzle_prj.api.response

data class LoginResponse (
    val token: String, val refreshToken: String,
    val userName: String,
    val userId: Long
)