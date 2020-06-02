package com.xinrui.berich.infra.fund.service

import com.xinrui.berich.domain.fund.model.Fund
import com.xinrui.berich.domain.fund.service.FundService
import io.reactivex.Observable
import javax.inject.Inject

class FundServiceImpl @Inject constructor() : FundService {
    override fun getFundList(): Observable<Fund> {
        return Observable.just(
            Fund("test1", "code1", "0.1"),
            Fund("test2", "code2", "0.2"),
            Fund("test3", "code3", "0.3")
        )
    }
}