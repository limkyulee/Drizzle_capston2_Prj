package com.example.drizzle_prj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drizzle_prj.databinding.ActivityLikeBinding


class LikeActivity : AppCompatActivity() {

    private var mBinding: ActivityLikeBinding ?= null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like)

        mBinding = ActivityLikeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}