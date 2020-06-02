package com.xinrui.berich.presentation.dashboard.fortune.presenter

import com.xinrui.berich.domain.fund.GetFundListUseCase
import com.xinrui.berich.presentation.dashboard.fortune.model.FundModel
import com.xinrui.berich.presentation.dashboard.fortune.view.FundListView
import javax.inject.Inject

class FundListPresenter @Inject constructor(val getFundListUseCase: GetFundListUseCase) {

    lateinit var fundListView: FundListView

    fun loadFundList() {
        val fundList = getFundListUseCase.execute("hello")
            .map { x -> FundModel(x.name, x.code, x.value) }
            .toList().blockingGet()
        fundListView.renderFundList(fundList)
    }
}
