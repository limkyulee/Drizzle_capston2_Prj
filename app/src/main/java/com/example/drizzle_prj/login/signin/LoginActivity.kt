package com.pickersoft.mylogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.drizzle_prj.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun onMatch(view: View) {
        val textId = findViewById<EditText>(R.id.editTextId)
        val textPass = findViewById<EditText>(R.id.editTextTextPassword)
        //val textTitle = findViewById<TextView>(R.id.textViewTitle)

        if (textId.text.toString() == "user" && textPass.text.toString() == "password") {
            Toast.makeText(this, "로그인 성공!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this,"로그인 실패!",Toast.LENGTH_LONG).show()
        }
    }
}