package com.example.standardthree_fragment.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.standardthree_fragment.R
import com.example.standardthree_fragment.databinding.ActivityMainBinding

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

        // // MainActivity실행되자마자 나타날 프레그먼트
        setFragment(HomeFragment())

        binding.mainBottomnavgation.setOnItemSelectedListener { item ->

            when (item.itemId){

                // home클릭시 HomeFragment()로 대체
                R.id.home -> {
                    setFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }

                // dashborad클릭시 DashboardFragment()로 대체
                R.id.dashborad -> {
                    setFragment(DashboardFragment())
                    return@setOnItemSelectedListener true
                }

                // notifications클릭시 NotificationsFragment()로 대체
                R.id.notifications -> {
                    setFragment(NotificationsFragment())
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }


    private fun setFragment(fragment : Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_framelayout, fragment)
            .commitAllowingStateLoss()
    }

}