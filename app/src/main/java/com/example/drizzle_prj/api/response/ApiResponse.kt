package com.example.drizzle_prj.api.response

data class ApiResponse<T>(
    val success: Boolean,
    val data: T? = null,
    val message: String? = null
) {
    companion object {
        //자체적으로 오류 응답을 만들어내야 하는 상황이 생길 수 있으므로 error() 함수 추가
        //reified 키워드는 인라인 함수에 붙을 수 있는 특별한 키워드로써 이 함수를 ApiResponse.error<Type>()
        //같은 형태로 호출할 수 있도록 해줌
        inline fun <reified T> error(message: String? = null) =
            ApiResponse(false, null as T?, message)
    }
}
