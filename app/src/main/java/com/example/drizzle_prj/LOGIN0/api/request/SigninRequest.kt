package com.example.drizzle_prj.LOGIN0.api.request

import android.util.Patterns

class SigninRequest (

    val email: String?,
    val password: String?
){

    fun isNotVaildEmail() =
        email.isNullOrBlank()
                || !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isNotVaildPassword() =
        password.isNullOrBlank() || password.length !in 8..20

}