package com.mtsteta.homework1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.fragment_container)

        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_menu_home -> {
                    navController.navigate(R.id.movieListFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_menu_user -> {
                    navController.navigate(R.id.userInfoFragment)
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}