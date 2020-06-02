package com.xinrui.berich.presentation

import android.app.Application
import com.xinrui.berich.presentation.di.AppModule
import com.xinrui.berich.presentation.di.DaggerApplicationComponent

class BerichApplication: Application() {
    val appComponent = DaggerApplicationComponent.builder()
        .appModule(AppModule(this))
        .build();
}

