package com.example.drizzle_prj.LOGIN0

import android.app.Application

class App : Application() {
    override fun OnCreate() {
        super.OnCreate()
        instance = this
    }

    companion object {
        lateinit var instance : App
    }
}