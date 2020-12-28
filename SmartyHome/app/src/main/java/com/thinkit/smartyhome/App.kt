package com.thinkit.smartyhome

import android.content.Context
import com.thinkit.smartyhome.di.AppComponent
import com.thinkit.smartyhome.di.AppModule
import com.thinkit.smartyhome.data.local.Preferences
import com.thinkit.smartyhome.di.DaggerAppComponent
import com.thinkit.smartyhome.ui.KnownViewModels
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject

class App : DaggerApplication() {
    @Inject
    lateinit var mKnownViewModels: KnownViewModels

    private lateinit var preferences: Preferences

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        preferences = Preferences(getSharedPreferences("smarty_home", Context.MODE_PRIVATE))

        val appComponent: AppComponent? = DaggerAppComponent
                .builder()
                .appModule(AppModule(applicationContext, preferences))
                .application(this)
                .build()
        appComponent?.inject(this)
        return appComponent
    }
}