package com.xinrui.berich.domain.fund.service

import com.xinrui.berich.domain.fund.model.Fund
import io.reactivex.Observable

interface FundService {
    fun getFundList(): Observable<Fund>;
}