package com.example.drizzle_prj.join

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.drizzle_prj.api.DrizzleApi
import com.example.drizzle_prj.api.request.JoinRequest
import com.example.drizzle_prj.api.response.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignupViewModel(app:Application) {

    val email = MutableLiveData("")
    val name= MutableLiveData("")
    val password= MutableLiveData("")
}