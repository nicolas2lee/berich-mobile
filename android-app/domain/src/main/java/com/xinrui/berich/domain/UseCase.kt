package com.xinrui.berich.domain

import io.reactivex.Observable

abstract class UseCase<Out, Params>{
    protected abstract fun buildUseCaseObservable(params: Params): Observable<Out>

    fun execute(params: Params): Observable<Out>{
        //Preconditions.checkNotNull(observer)
        return this.buildUseCaseObservable(params)
          //  .subscribeOn(Schedulers.from(threadExecutor))
            //.observeOn(postExecutionThread.getScheduler())
        //addDisposable(observable.subscribeWith(observer))
    }
}