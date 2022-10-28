package com.example.drizzle_prj.join

import android.app.Application
import android.graphics.Paint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drizzle_prj.api.DrizzleApi
import com.example.drizzle_prj.api.request.JoinRequest
import com.example.drizzle_prj.api.response.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import splitties.toast.*
import android.util.Log

public class JoinViewModel(app:Application){

    val email = MutableLiveData("")
    val name= MutableLiveData("")
    val password= MutableLiveData("")

    suspend fun join(){
        val request =JoinRequest(email.value, password.value, name.value)
        if(isNotValidJoin(request))
            return

        try{
            val response =requestJoin(request)
            onJoinResponse(response)

        }catch (e: Exception){
            Log.e("join error","",e)
            toast("알 수 없는 오류가 발생했습니다. ")
        }
    }

    private fun isNotValidJoin(joinRequest: JoinRequest)=
        when{
            joinRequest.isNotValidEmail()->{
                toast("이메일 형식이 정확하지 않습니다.")
                true
            }
            joinRequest.isNotValidPassword()->{
                toast("비밀번호는 8자 이상 20자 이하로 입력해주세요.")
                true
            }
            joinRequest.isNotValidName()->{
                toast("이름은 2자 이상 20자 이하로 입력해주세요.")
                true
            }
            else -> false
        }

    private suspend fun requestJoin(request: JoinRequest)=
        withContext(Dispatchers.IO){
            DrizzleApi.instance.join(request)
        }

    private fun onJoinResponse(response: ApiResponse<Void>){
        if (response.success){
            toast("회원가입이 되었습니다. 로그인 후 이용해주세요.")
            //finishActivity()
        }else{
            toast(response.message ?:"알 수 없는 오류가 발생했습니다.")
        }
    }

    fun btnClick(){
    }
}