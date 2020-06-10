package com.xinrui.berich.presentation.dashboard.fortune.view

import com.xinrui.berich.presentation.dashboard.fortune.model.FundModel

interface FundListView {
    fun renderFundList(funds: List<FundModel>);

    fun viewFunndDetail(fund: FundModel);
}