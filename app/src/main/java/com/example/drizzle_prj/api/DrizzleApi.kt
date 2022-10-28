package com.example.drizzle_prj.api

import com.example.drizzle_prj.api.request.JoinRequest
import com.example.drizzle_prj.api.response.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface DrizzleApi {

    @GET("/api/v1/hello")
    suspend fun hello(): ApiResponse<String>

    companion object {
        val instance = ApiGenerator()
            .generate(DrizzleApi::class.java)
    }

    @POST("/api/v1/users")
    suspend fun join(@Body JoinRequest: JoinRequest)
        :ApiResponse<Void>
}