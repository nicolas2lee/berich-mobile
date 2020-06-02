package com.xinrui.berich.presentation.dashboard.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xinrui.berich.R
import com.xinrui.berich.presentation.dashboard.fortune.view.fragment.DashboardFragment
import com.xinrui.berich.presentation.BerichApplication

class DashboardActivity : AppCompatActivity() {

    //lateinit var dashboardComponent: Component

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                //textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_fortune -> {
                //textMessage.setText(R.string.title_fortune)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.dashboard_fragement_container, DashboardFragment.newInstance())
                    .commitNow()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_myaccount -> {
                //textMessage.setText(R.string.title_myaccount)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        initializeInjector()
    }

    private fun initializeInjector() {
        (application as BerichApplication).appComponent.inject(this)
    }
}
