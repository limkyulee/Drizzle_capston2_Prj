package com.example.drizzle_prj

import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle


class MainNaviActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navi)


        var btmNavigation = findViewById(R.id.bottomNavigation) as BottomNavigationView

        btmNavigation.run { setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    // 다른 프래그먼트 화면으로 이동하는 기능
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, homeFragment).commit()
                }
                R.id.store -> {
                    val storeFragment = StoreFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, storeFragment).commit()
                }
                R.id.like -> {
                    val likeFragment = LikeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, likeFragment).commit()
                }
                R.id.myPage -> {
                    val myPageFragment = MypageFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, myPageFragment).commit()
                }
            }
            true
        }
            selectedItemId = R.id.home
        }
    }
}
