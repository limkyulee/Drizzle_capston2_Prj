package com.example.drizzle_prj.api.request

import android.util.Patterns

class JoinRequest(val email:String?,
                    val password:String?,
                    val name: String?) {
    //각각의 필드값을 검증하는 함수 포함
    //안드 SDK에 Patterns 유틸리티에 이메일 검증을 도와주는 EMAIL_ADDRESS 정규표현식 사용
    fun isNotValidEmail()=
        email.isNullOrBlank()
                || !Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun isNotValidPassword()=
        password.isNullOrBlank() || password.length !in 8..20

    fun isNotValidName()=
        name.isNullOrBlank() || name.length !in 2..20
}