package com.xinrui.berich.domain.fund

import com.xinrui.berich.domain.UseCase
import com.xinrui.berich.domain.fund.model.Fund
import com.xinrui.berich.domain.fund.service.FundService
import io.reactivex.Observable
import javax.inject.Inject

class GetFundListUseCase @Inject constructor(val fundService: FundService): UseCase<Fund, String>(){

    override fun buildUseCaseObservable(params: String): Observable<Fund> {
        return fundService.getFundList()
        //return Observable.just(Fund("hello", "hello", "hello"))
    }

}