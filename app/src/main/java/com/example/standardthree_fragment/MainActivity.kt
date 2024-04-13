package com.example.standardthree_fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.standardthree_fragment.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        BottomNavigation()

    }


    // bottomNavigation 구현함수
    private fun BottomNavigation(){


        // main_framelayout레이아웃을 HomeFragment로 대체
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_framelayout, HomeFragment())
            .commitAllowingStateLoss()


        binding.mainBottomnavgation.setOnItemSelectedListener { item ->

            when (item.itemId){

                // home클릭시 HomeFragment()로 대체
                R.id.home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_framelayout, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                // mypage클릭시 MypageFragment()로 대체
                R.id.dashborad -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_framelayout, DashboardFragment())
                        .commitAllowingStateLoss()

                    return@setOnItemSelectedListener true
                }

                // mypage클릭시 MypageFragment()로 대체
                R.id.notifications -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_framelayout, NotificationsFragment())
                        .commitAllowingStateLoss()

                    return@setOnItemSelectedListener true
                }

            }
            false
        }


    }

}