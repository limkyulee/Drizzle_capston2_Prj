package com.example.drizzle_prj.api.request

import android.util.Patterns

class LoginRequest (

    val email: String?,
    val password: String?
){

    fun isNotVaildEmail() =
        email.isNullOrBlank()
                || !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isNotVaildPassword() =
        password.isNullOrBlank() || password.length !in 8..20

}