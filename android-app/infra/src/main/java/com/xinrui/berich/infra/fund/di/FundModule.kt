package com.xinrui.berich.infra.fund.di

import com.xinrui.berich.domain.fund.service.FundService
import com.xinrui.berich.infra.fund.service.FundServiceImpl
import dagger.Binds
import dagger.Module

@Module
abstract class FundModule {
    @Binds
    abstract fun bindFundService(fundServiceImpl: FundServiceImpl): FundService
}