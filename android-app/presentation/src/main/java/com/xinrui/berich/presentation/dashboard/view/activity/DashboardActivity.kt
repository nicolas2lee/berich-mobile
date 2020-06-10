package com.xinrui.berich.presentation.dashboard.view.activity

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xinrui.berich.R
import com.xinrui.berich.presentation.dashboard.fortune.view.fragment.FundListFragment
import com.xinrui.berich.presentation.BerichApplication
import com.xinrui.berich.presentation.dashboard.fortune.view.fragment.FundDetail

class DashboardActivity : AppCompatActivity(), FundDetail.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //lateinit var dashboardComponent: Component

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
       /*     R.id.navigation_home -> {
                //textMessage.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }*/
            R.id.navigation_fortune -> {
                //textMessage.setText(R.string.title_fortune)
                return@OnNavigationItemSelectedListener navigateToDefaultFortunePage()
            }
            R.id.navigation_myaccount -> {
                //textMessage.setText(R.string.title_myaccount)
                return@OnNavigationItemSelectedListener true
            } else -> {
                //textMessage.setText(R.string.title_fortune)
            return@OnNavigationItemSelectedListener navigateToDefaultFortunePage()
        }
        }
    }

    private fun navigateToDefaultFortunePage(): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.dashboard_fragement_container, FundListFragment.newInstance())
            .commitNow()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        initializeInjector()
        navigateToDefaultFortunePage()
    }

    private fun initializeInjector() {
        (application as BerichApplication).appComponent.inject(this)
    }
}
