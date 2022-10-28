package com.example.drizzle_prj.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiGenerator {
    fun <T> generate(api:Class<T>):T =Retrofit.Builder()
        .baseUrl(HOST)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient())
        .build()
        .create(api)

    private fun httpClient()=
        OkHttpClient.Builder().apply{
            addInterceptor(httpLoggingInterceptor())
        }.build()

    private fun httpLoggingInterceptor()=
        HttpLoggingInterceptor().apply{
            level=HttpLoggingInterceptor.Level.BODY
        }

    companion object{
        //HOST 부분은 하드코딩, HOST 값으로 사용된 10.0.2.2 아이피는 안드로이드 에뮬레이터에서 로컬호스트에
        //띄운 서버를 지칭할때 사용되는 아이피임
        const val HOST ="http://10.0.2.2:8080"
    }
}