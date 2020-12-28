package com.thinkit.smartyhome.di

import com.thinkit.smartyhome.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

import dagger.android.AndroidInjector

import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder
        fun build(): AppComponent?
        fun appModule(appModule: AppModule?): Builder
    }
}