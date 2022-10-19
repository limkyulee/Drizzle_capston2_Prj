package com.example.drizzle_prj.LOGIN0.signin

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.drizzle_prj.LOGIN0.api.DrizzleApi
import com.example.drizzle_prj.LOGIN0.api.request.SigninRequest
import com.example.drizzle_prj.LOGIN0.api.response.ApiResponse
import com.example.drizzle_prj.LOGIN0.api.response.SigninResponse
import com.example.drizzle_prj.LOGIN0.common.Prefs
import net.codephobia.ankomvvm.lifecycle.BaseViewModel
//import org.jetbrains.anko.error

class SinginViewModel(app: Application) : BaseViewModel(app){

    //1
    val email = MutableLiveData("")
    val password = MutableLiveData("")

    suspend fun signin() {
        val request = SigninRequest(email.value, password.value)
        if(isNotVaildSignin(request))
            return

        try {
            val response = requestSignin(request)
            onSigninResponse(response)
        } catch (e: Exception) {
            error("signin error", e)
            Toast("알 수 없는 오류가 발생했습니다.")
        }
    }

    private fun  isNotVaildSignin(request: SigninRequest) =
        when {
            request.isNotVaildEmail() -> {
                Toast("이메일 형식이 정확하지 않습니다.")
                //Toast.makeText("", "", Toast.LENGTH_SHORT).show()
                true
            }
            request.isNotVaildPassword() -> {
                Toast("비밀번호는 8자 이상 20자 이하로 입력해주세요.")
                true
            }
            else -> false
        }

    private suspend fun requestSignin(request: SigninRequest) =
        withContext(DispatcherState.IO) {
            DrizzleApi.instanse.signin(request)
        }

    private fun onSigninResponse(response: ApiResponse<SigninResponse>) {
        if(response.success && response.data != null) {

            Prefs.token = response.data.token
            Prefs.refreshToken = response.data.refreshToken
            Prefs.userName = response.data.userName
            Prefs.userId = response.data.userId


            Toast("로그인되었습니다.") //1
            //TODO. 상품리스트 화면으로 이동 // 책 주석
        } else {
            Toast(response.message ?: "알 수 없는 오류가 발생했습니다.")
        }
    }

    private fun Toast(s:String){
        //이게 맞는지는 모르겠음.. 원래 toast
    }

}