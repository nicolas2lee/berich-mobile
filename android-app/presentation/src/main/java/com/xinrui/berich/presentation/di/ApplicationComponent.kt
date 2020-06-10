package com.xinrui.berich.presentation.di

import com.xinrui.berich.infra.fund.di.FundModule
import com.xinrui.berich.presentation.dashboard.fortune.view.fragment.FundListFragment
import com.xinrui.berich.presentation.dashboard.view.activity.DashboardActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class, FundModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(activity: DashboardActivity)

    fun inject(fragment: FundListFragment)
}