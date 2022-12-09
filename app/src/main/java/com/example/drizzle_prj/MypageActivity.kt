package com.example.drizzle_prj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drizzle_prj.databinding.ActivityMypageBinding

class MypageActivity : AppCompatActivity() {

    private var mBinding: ActivityMypageBinding ?= null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like)

        mBinding = ActivityMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mypageLikeBtn.setOnClickListener {

            val intent = Intent(this, LikeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }
}