package com.example.drizzle_prj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.drizzle_prj.api.DrizzleApi
import kotlinx.coroutines.runBlocking


// splash 화면 동작
class SplashActivity : AppCompatActivity() {
    // After 3000 mileSeconds / 3 seconds your next activity will display.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        loadSplashScreen()
        /*
        runBlocking {
            try{
                val response = DrizzleApi.instance.hello()
                Log.d("MainActivity",response.data)
            } catch (e:Exception){
                Log.e("MainActivity", "Hello API 호출 오류", e)
            }
        }

         */
    }

    private fun loadSplashScreen(){
        Handler().postDelayed({
            // You can declare your desire activity here to open after finishing splash screen. Like MainActivity
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 10000)
    }
}