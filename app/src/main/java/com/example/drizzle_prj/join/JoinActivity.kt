package com.example.drizzle_prj.join


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drizzle_prj.R
import com.example.drizzle_prj.databinding.ActivityJoinBinding
import androidx.databinding.DataBindingUtil
import splitties.toast.*


class JoinActivity : AppCompatActivity() {
    private lateinit var binding: ActivityJoinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_join)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_join)

    }

}