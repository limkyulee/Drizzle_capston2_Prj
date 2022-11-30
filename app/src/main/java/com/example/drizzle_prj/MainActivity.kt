package com.example.drizzle_prj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.drizzle_prj.api.DrizzleApi
import com.example.drizzle_prj.databinding.ActivityMainBinding
import com.example.drizzle_prj.databinding.ActivityShampooListBinding
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    // 바인딩 객체 선언
    private var mBinding: ActivityMainBinding ?= null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         //바인딩 초기화
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        // 생성된 뷰 액티비티에 표시시
       setContentView(binding.root)


        binding.shampooBtn.setOnClickListener {
            View.OnClickListener {
                //다음화면으로 이동하기 위한 인텐트 객체 생성
                val intent = Intent(this, shampooListActivity::class.java)
                startActivity(intent)   //intent에 저장되어 있는 엑티비티 쪽으로 이동한다
            }

            finish() //자기 자신 액티비티 파괴

        }
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}

